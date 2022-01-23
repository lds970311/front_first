// Author : evan lee
// Time ： 2022-01-22  18:35
// FILENAME : PageBean.java
// STATEMENT: 

package com.codewolf.domain;

import lombok.Data;

import java.util.List;

/**
 * 分页器
 */
@Data
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPages; //总页码
    private List<T> list; //每页的数据
    private int currentPage; //当前页码
    private int rows; //每页的记录数

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPages, List<T> list, int currentPage, int rows) {
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.list = list;
        this.currentPage = currentPage;
        this.rows = rows;
    }
}
