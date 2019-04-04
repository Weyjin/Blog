package com.blog.service;

import com.blog.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

    User getUserByPrimaryKey(int id);
    List<User> getUsers();
    List<User> getUsersByMap(Map<String,Object> map);
    boolean updateUser(User user);

    ResponseEntity<Map<String,Object>> addUser(User user,String ip);
}
