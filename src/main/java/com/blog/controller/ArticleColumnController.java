package com.blog.controller;


import com.blog.entity.ArticleColumn;
import com.blog.service.ArticleColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleColumnController {

    @Autowired
    private ArticleColumnService articleColumnService;


    /**
     * 获得全部栏目
     * @return
     */
    @RequestMapping("articleColumns")
    @ResponseBody
    public List<ArticleColumn> getArticleColumns(){
        List<ArticleColumn> articleColumns=articleColumnService.toList(new HashMap<>());
        return articleColumns;
    }

    /**
     * 添加栏目
     * @param name
     * @return
     */
    @RequestMapping(value = "articleColumn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addArticleColumn(String name){
        ArticleColumn column=new ArticleColumn();
        Map<String,Object> map=new HashMap<>();


        if(name!=null&!name.equals("")){
            column.setName(name);
            boolean success=articleColumnService.insert(column);
            if(success){
                map.put("msg","添加成功");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
        }

        map.put("msg","添加失败");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    /**
     * 获得某一栏目
     * @param id
     * @return
     */
    @RequestMapping(value = "articleColumns/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ArticleColumn getArticleColumn(@PathVariable int id){
        ArticleColumn column=articleColumnService.selectByPrimaryKey(id);
        return column;
    }

    /**
     * 删除某一栏目
     * @param id
     * @return
     */
    @RequestMapping(value = "articleColumns/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteArticleColumn(@PathVariable int id){
        Map<String,Object> map=new HashMap<>();
        boolean success=articleColumnService.delete(id);
        if(success){
            map.put("msg","删除成功");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        map.put("msg","删除失败");
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }









}
