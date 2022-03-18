// Author : evan lee
// Time ： 2022-03-18  7:01
// FILENAME : CheckItemDao.java
// STATEMENT: 

package cn.evanlee.dao;

import cn.evanlee.pojo.CheckItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("all")
public interface CheckItemDao {
    /**
     * 添加检查项
     *
     * @param checkItem
     */
    void addCheckItem(CheckItem checkItem);

    /**
     * 分页查询
     *
     * @param pageSize
     * @param currentPage
     * @param queryString
     * @return
     */
    Page<CheckItem> findByPage(String queryString);

    /**
     * 根据id删除检查项
     *
     * @param parseInt
     * @return
     */
    int deleteById(@Param("parseInt") int parseInt);
}
