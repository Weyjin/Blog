package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;



    @Override
    public boolean insert(Article object) {
        return articleDao.insert(object)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(Article object) {
        return false;
    }

    @Override
    public List<Article> toList(Map<String, Object> map) {
        return null;
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleDao.selectByPrimaryKey(id);
    }

    @Override
    public Article selectByOnly(Map<String, Object> map) {
        return null;
    }
}
