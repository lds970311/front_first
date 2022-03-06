// Author : evan lee
// Time ： 2022-03-05  19:45
// FILENAME : Page.java
// STATEMENT: 

package com.evan.note.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页工具类
@Data
@NoArgsConstructor
public class Page<T> {
    private Integer pageNo; //第几页
    private Integer pageSize; //每页显示的数量
    private long totalCount; //总记录数
    private int totalPages;
    private Integer prevPage; //上一页
    private Integer nextPage; //下一页

    private Integer startNavPage; //导航开始页
    private Integer endNavPage; //导航结束页

    private List<T> dataList; //当前页数据集合

    public Page(Integer pageNo, Integer pageSize, long totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        if (totalCount % pageSize == 0) {
            this.totalPages = (int) (totalCount / pageSize);
        } else {
            this.totalPages = (int) (totalCount / pageSize) + 1;
        }
        this.prevPage = Math.max(this.pageNo - 1, 1);
        this.nextPage = Math.min(this.pageNo + 1, this.totalPages);

        this.startNavPage = this.pageNo - 2;
        this.endNavPage = this.pageNo + 2;

        if (this.startNavPage < 1) {
            this.startNavPage = 1;
            this.endNavPage = Math.min(this.startNavPage + 4, this.totalPages);
        }
        if (this.endNavPage > this.totalPages) {
            this.endNavPage = this.totalPages;
            this.startNavPage = Math.max(this.endNavPage - 4, 1);
        }
    }
}
