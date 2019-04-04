package com.blog.dao;

import com.blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao{

    User getUserByPrimaryKey(int id);

    List<User> getUsers();
    List<User> getUsersByMap(Map<String,Object> map);
    int updateUser(User user);

    int addUser(User user);



}
