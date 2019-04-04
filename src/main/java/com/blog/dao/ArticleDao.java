package com.blog.dao;

import com.blog.entity.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends IBaseDao<Article,Integer> {
}
