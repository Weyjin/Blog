package com.blog.controller;

import com.blog.entity.User;
import com.blog.jsonFilter.SerializedField;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView view=new ModelAndView();
        view.setViewName("home/index");
        return view;
    }

    @RequestMapping("default")
    public ModelAndView defaultView(){
        ModelAndView view=new ModelAndView();
        view.setViewName("home/default");
        return view;
    }

    @RequestMapping("users")
    @ResponseBody
    @SerializedField(includes = {"id","password"})
    public List<User>  getUsers(){
        List<User> users=userService.getUsers();
        return users;
    }

    @RequestMapping("users/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){
        User user=userService.getUserByPrimaryKey(id);
        return user;
    }

    @RequestMapping("columns")
    public ModelAndView columns(){
        ModelAndView view=new ModelAndView();
        view.setViewName("home/columns");
        return view;
    }

}
