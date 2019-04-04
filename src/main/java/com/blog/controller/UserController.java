package com.blog.controller;

import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){
        User user=userService.getUserByPrimaryKey(id);
        return user;
    }

    @RequestMapping("users")
    @ResponseBody
    public List<User> getUsers(){
        List<User> users=userService.getUsers();
        return users;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addUser(@RequestBody User user,HttpServletRequest request){
        String ip=null;
        try {
             ip= IPUtils.getIpAddr(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  userService.addUser(user,ip);
    }


    @RequestMapping(value = "/{id}/update",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,Object>> updateUser(@PathVariable String id){
        return new ResponseEntity<Map<String,Object>>(new HashMap<>(), HttpStatus.OK);
    }




}
