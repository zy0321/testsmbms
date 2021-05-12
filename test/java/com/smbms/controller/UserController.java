package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.entity.Role;
import com.smbms.entity.User;
import com.smbms.service.RoleService;
import com.smbms.service.UserService;
import com.smbms.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("login.do")
    public String login(String userCode, String userPassword, HttpSession session){
        List<User> list = userService.get(userCode, userPassword);
        if (list.size()>0){
            User user = list.get(0);
            session.setAttribute("user",user);
            return "frame";
        }else {
            session.setAttribute("error","账号或密码错误!!!");
            return "redirect:../login.jsp";
        }
    }
    @RequestMapping("outlogin.do")
    public String out(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }

    @RequestMapping("modify.do")
    public String modify(){
        return "provider/pwdmodify";
    }

    @RequestMapping("UpdatePassword.do")
    @ResponseBody
    public String update(String oldpassword,String newpassword,String rnewpassword,HttpSession session){

        User user = (User) session.getAttribute("user");

        user.setUserPassword(newpassword);
        int update = userService.Update(user);
        if (update>0){
            session.invalidate();
            return  " <script>\n" +
                    "        alert(\"Successfully modified\")\n" +
                    "        window.location.href=\"/smbms/login.jsp\";\n" +
                    "    </script>";
        }else {
            return "修改失败";
        }
    }

    @RequestMapping("userlist.do")
    public String userlist(String queryname,
                           @RequestParam(defaultValue = "0") Integer queryUserRole,
                           @RequestParam(defaultValue = "1") Integer pageNo,
                           @RequestParam(defaultValue = "5") Integer pageSize,
                           Model model){
        int i=userService.getCount(queryname,queryUserRole);
        System.out.println(queryname+""+queryUserRole+""+pageNo+""+pageSize);

        List<Role> roleList = roleService.getAll();

        Page page=new Page();
        page.setPageSize(pageSize);
        page.setCurrentPageNo((pageNo-1)*5+page.getCurrentPageNo());
        page.setTotalCount(i);

        List<User> userList = userService.getlist(queryname, queryUserRole, page.getCurrentPageNo()-1, pageSize);

        model.addAttribute("userList",userList);
        model.addAttribute("page",page);
        model.addAttribute("queryname",queryname);
        model.addAttribute("queryUserRole",queryUserRole);
        model.addAttribute("roleList",roleList);
        model.addAttribute("pageNo",pageNo);

        return "user/userlist";
    }

    @RequestMapping("adduser.do")
    public String addUser(){
        return "user/useradd";
    }
    @RequestMapping("user.do")
    @ResponseBody
    public String Userc(String userCode){
        return JSON.toJSONString( userService.getUserCode(userCode));
    }


    @RequestMapping("userAdd.do")
    public String UserAdd(User user,@RequestParam(value ="idPicPath_1", required = false) MultipartFile file,
                          HttpServletRequest request) throws IOException {
        if (file!=null){
            String realPath = request.getServletContext().getRealPath("/statics/images/");
            file.transferTo(new File(realPath+ File.separator+file.getOriginalFilename()));//图片名称
            user.setIdPicPath("statics/images/"+file.getOriginalFilename());
        }
        int add = userService.add(user);
        if (add>0){
            return "redirect:/user/userlist.do";
        }
        return "user/useradd";
    }

    @RequestMapping("userAdd1.do")
    @ResponseBody
    public String UserAdd1(User user,@RequestParam(value ="idPicPath_1", required = false) MultipartFile file,
                          HttpServletRequest request) throws IOException {
        if (file!=null){
            String realPath = request.getServletContext().getRealPath("/statics/images/");
            file.transferTo(new File(realPath+ File.separator+file.getOriginalFilename()));//图片名称
            user.setIdPicPath("statics/images/"+file.getOriginalFilename());
        }
        int add = userService.add(user);
        if (add>0){
            return "true";
        }
        return "false";
    }



    @RequestMapping(value = "getRoleName.do",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//    @RequestMapping("getRoleName.do")
    @ResponseBody
    public String getRoleName(){
        List<Role> list1=roleService.getAll();
        String s = JSON.toJSONString(list1);
        return s;
    }

    @RequestMapping("viewUser.do")
    public String viewUser(Integer uid,Model model){
        User user=userService.getById(uid);
        model.addAttribute("user",user);
        return "user/userview";
    }
    @RequestMapping("usermodify.do")
    public String usermodify(Integer uid,Model model){
        User user=userService.getById(uid);
        model.addAttribute("user",user);
        return "user/usermodify";
    }
    @RequestMapping("delUser.do")
    @ResponseBody
    public String delUser(Integer userid){
        User user=userService.getById(userid);
        if (user.getRoleName().equals("系统管理员")){

            return JSON.toJSONString( userService.del(userid));
        }else {
            return "false";
        }
    }
    @RequestMapping("update.do")
    public String update(User user,Model model){

        boolean a = userService.update(user);
        if (a){
            model.addAttribute("user",user);
            return "user/usermodify";
        }else {
            return "user/usermodify";
        }
    }
}
