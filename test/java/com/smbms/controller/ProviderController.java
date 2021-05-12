package com.smbms.controller;

import com.smbms.entity.Provider;
import com.smbms.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProviderController {

    @Autowired
    ProviderService providerService;



    @RequestMapping("getById.do")
    public String GetByid(Integer id, Model model){
        List<Provider> byId = providerService.getById(id);
        model.addAttribute("by",byId);
        return "provider/Showoff";
    }
    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public String GetByid1(@PathVariable Integer id, Model model){
        if (id==-1){
            id=null;
        }
        List<Provider> byId = providerService.getById(id);

        model.addAttribute("by",byId);

        return "provider/Showoff";
    }



    @RequestMapping("add.do")
    public String add(@ModelAttribute("provider") Provider provider, Model model) throws Exception {
        int add = providerService.add(provider);
        if (add<=0){
            model.addAttribute("error","添加失败！！！！");
            return "../index";
        }else {
            List<Provider> byId = providerService.getById(null);
            model.addAttribute("by",byId);
            return "provider/Showoff";
        }
    }

    @RequestMapping("proCodeBlur.do")
    @ResponseBody
    public String proCodeBlur(String proCode){
        Provider byProCode = providerService.getByProCode(proCode);
        if (byProCode==null){
            return "true";
        }else {
            return "false";
        }
    }

}
