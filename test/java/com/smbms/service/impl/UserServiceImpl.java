package com.smbms.service.impl;

import com.smbms.entity.User;
import com.smbms.mapper.UserMapper;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> get(String name, String password) {
        return userMapper.get(name,password);
    }

    @Override
    public int Update(User user) {
        return  userMapper.Update(user);
    }

    @Override
    public boolean getUserCode(String userCode) {
        return userMapper.getUserCode(userCode)!=null?true:false;
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public List<User> getlist(String queryname, Integer queryUserRole,Integer PageNo,Integer pageSize) {
        return userMapper.getlist(queryname,queryUserRole,PageNo,pageSize);
    }


    @Override
    public int getCount(String queryname, Integer queryUserRole) {
        return userMapper.getCount(queryname,queryUserRole);
    }

    @Override
    public User getById(Integer uid) {
        return userMapper.getById(uid);
    }

    @Override
    public boolean del(Integer userid) {
        return userMapper.delUser(userid)>0?true:false;
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user)>0?true:false;
    }
}
