// Author : evan lee
// Time ： 2022-03-18  6:59
// FILENAME : CheckItemImpl.java
// STATEMENT: 

package cn.evanlee.service.impl;

import cn.evanlee.constant.MessageConstant;
import cn.evanlee.dao.CheckItemDao;
import cn.evanlee.entity.QueryPageBean;
import cn.evanlee.pojo.CheckItem;
import cn.evanlee.result.PageResult;
import cn.evanlee.result.Result;
import cn.evanlee.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.addCheckItem(checkItem);
    }

    @Override
    public Result<PageResult<CheckItem>> findByPage(QueryPageBean queryPageBean) {
        Integer pageSize = queryPageBean.getPageSize();
        Integer currentPage = queryPageBean.getCurrentPage();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> pageResult = checkItemDao.findByPage(queryString);
        long total = pageResult.getTotal();
        List<CheckItem> result = pageResult.getResult();
        PageResult<CheckItem> pageResult1 = new PageResult<>(total, result);
        return new Result<>(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, pageResult1);
    }

    @Override
    public Result<Object> deleteById(String id) {
        Result<Object> result = new Result<>();
        //判断是否关联到检查组
        long count = checkItemDao.findCountByCheckItemId(Integer.parseInt(id));
        if (count > 0) {
            result.setMessage("该检查项已关联检查组,不能删除");
            result.setFlag(false);
            return result;
        }
        int row = checkItemDao.deleteById(Integer.parseInt(id));
        if (row > 0) {
            //说明已经关联,不能删除
            result.setFlag(true);
            result.setMessage(MessageConstant.DELETE_CHECKGROUP_SUCCESS);
            return result;
        }
        result.setFlag(false);
        result.setMessage(MessageConstant.DELETE_CHECKGROUP_FAIL);
        return result;
    }
}
