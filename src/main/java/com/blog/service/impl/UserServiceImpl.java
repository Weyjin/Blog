package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByPrimaryKey(int id) {
        return userDao.getUserByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public List<User> getUsersByMap(Map<String, Object> map) {
        return userDao.getUsersByMap(map);
    }

    @Override
    public boolean updateUser(User user) {
        int count=userDao.updateUser(user);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public ResponseEntity<Map<String,Object>> addUser(User user,String ip) {

        boolean click=false;
        if(user.getName()==null|user.getName().equals("")){
            click=true;
        }
        if(user.getPhone()==null|user.getPhone().equals("")){
            click=true;
        }
        if(user.getEmail()==null|user.getEmail().equals("")){
            click=true;
        }
        if(user.getPassword()==null|user.getPassword().equals("")){
            click=true;
        }

        if(click){
            Map<String,Object> map=new HashMap<>();
            map.put("msg","信息不完整");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
        }

        user.setSex("男");
        user.setRegisterTime(new Date());
        user.setRegisterIP(ip);
        user.setLastLoginIP(ip);

        int count=userDao.addUser(user);
        if(count>0){
            Map<String,Object> map=new HashMap<>();
            map.put("msg","添加成功");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }else{
            Map<String,Object> map=new HashMap<>();
            map.put("msg","添加失败");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
        }

    }
}
