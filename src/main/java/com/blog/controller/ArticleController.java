package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.ArticleColumn;
import com.blog.entity.ArticleSort;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    /**
     * 获得全部文章
     * @return
     */
    @RequestMapping(value = "articles",method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getArticles(){
        return null;
    }

    /**
     * 添加文章
     * @return
     */
    @RequestMapping(value = "article",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addArticle(Article article, HttpServletRequest request){

        User user=new User();
        user.setId(8);
        article.setUser(user);
        ArticleColumn column=new ArticleColumn();
        column.setId(1);
        article.setColumn(column);

        article.setReleaseTime(new Date());

        ArticleSort sort=new ArticleSort();
        sort.setId(1);
        article.setSort(sort);
        try {
            article.setReleaseIP(IPUtils.getIpAddr(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean success=articleService.insert(article);

        Map<String,Object> map=new HashMap<>();
        if(success){
            map.put("msg","添加文章成功");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        map.put("msg","添加文章失败");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    /**
     * 获得某一篇文章
     * @param id
     * @return
     */
    @RequestMapping(value = "articles/{id}",method = RequestMethod.GET)
    public ModelAndView getArticle(@PathVariable int id){
        Article article=articleService.selectByPrimaryKey(id);
        ModelAndView view=new ModelAndView();
        view.setViewName("article/details");
        view.addObject("article",article);
        return view;
    }

    /**
     * 删除某一篇文章
     * @param id
     * @return
     */
    @RequestMapping(value = "articles/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,Object>> deleteArticle(@PathVariable String id){
        return null;
    }



    @RequestMapping("article/create")
    public ModelAndView create(){
        ModelAndView view=new ModelAndView();
        view.setViewName("article/create");
        return view;
    }



}
