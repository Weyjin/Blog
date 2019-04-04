package com.blog.entity;

import java.util.Date;

/**
 * 文章
 */
public class Article {

    private int id;
    private String name;
    private Date releaseTime;
    private String releaseIP;
    private int click;
    private ArticleSort sort;
    private User user;
    private ArticleColumn column;
    private int model;
    private String content;
    private int up;
    private int support;
    private int is_delete;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReleaseIP() {
        return releaseIP;
    }

    public void setReleaseIP(String releaseIP) {
        this.releaseIP = releaseIP;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public ArticleSort getSort() {
        return sort;
    }

    public void setSort(ArticleSort sort) {
        this.sort = sort;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleColumn getColumn() {
        return column;
    }

    public void setColumn(ArticleColumn column) {
        this.column = column;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}
