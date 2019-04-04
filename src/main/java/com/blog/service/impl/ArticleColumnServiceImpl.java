package com.blog.service.impl;

import com.blog.dao.ArticleColumnDao;
import com.blog.entity.ArticleColumn;
import com.blog.service.ArticleColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleColumnServiceImpl implements ArticleColumnService {

    @Autowired
    private ArticleColumnDao articleColumnDao;


    @Override
    public boolean insert(ArticleColumn object) {
        return articleColumnDao.insert(object)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return articleColumnDao.delete(id)>0;
    }

    @Override
    public boolean update(ArticleColumn object) {
        return articleColumnDao.update(object)>0;
    }

    @Override
    public List<ArticleColumn> toList(Map<String, Object> map) {
        return articleColumnDao.toList(map);
    }

    @Override
    public ArticleColumn selectByPrimaryKey(Integer id) {
        return articleColumnDao.selectByPrimaryKey(id);
    }

    @Override
    public ArticleColumn selectByOnly(Map<String, Object> map) {
        return articleColumnDao.selectByOnly(map);
    }
}
