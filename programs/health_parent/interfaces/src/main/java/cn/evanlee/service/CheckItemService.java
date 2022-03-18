// Author : evan lee
// Time ： 2022-03-18  6:53
// FILENAME : CheckItemService.java
// STATEMENT: 

package cn.evanlee.service;

import cn.evanlee.entity.QueryPageBean;
import cn.evanlee.pojo.CheckItem;
import cn.evanlee.result.PageResult;
import cn.evanlee.result.Result;

//检查项管理接口
public interface CheckItemService {
    void add(CheckItem checkItem);

    Result<PageResult<CheckItem>> findByPage(QueryPageBean queryPageBean);

    Result<Object> deleteById(String id);
}
