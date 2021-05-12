package com.smbms.service;

import com.smbms.entity.User;

import java.util.List;

public interface UserService {
    List<User> get(String name, String password);

    int Update(User user);

    boolean getUserCode(String userCode);

    int add(User user);

    List<User> getlist(String queryname, Integer queryUserRole, Integer PageNo, Integer pageSize);


    int getCount(String queryname, Integer queryUserRole);

    User getById(Integer uid);

    boolean del(Integer userid);

    boolean update(User user);
}
