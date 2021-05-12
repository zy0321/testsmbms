package com.smbms.mapper;

import com.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> get(@Param("name") String name, @Param("password") String password);

    int Update(User user);

    User getUserCode(String userCode);

    int add(User user);

    List<User> getlist(@Param("queryname") String queryname,
                       @Param("queryUserRole") Integer queryUserRole,
                       @Param("PageNo") Integer PageNo,
                       @Param("pageSize") Integer pageSize);


    int getCount(@Param("queryname") String queryname, @Param("queryUserRole") Integer queryUserRole);

    User getById(Integer uid);

    int delUser(Integer userid);

    int update(User user);
}
