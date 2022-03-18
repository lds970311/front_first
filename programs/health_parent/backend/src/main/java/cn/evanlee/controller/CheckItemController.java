// Author : evan lee
// Time ： 2022-03-18  6:43
// FILENAME : CheckItemController.java
// STATEMENT: 

package cn.evanlee.controller;

import cn.evanlee.constant.MessageConstant;
import cn.evanlee.entity.QueryPageBean;
import cn.evanlee.pojo.CheckItem;
import cn.evanlee.result.PageResult;
import cn.evanlee.result.Result;
import cn.evanlee.service.CheckItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 检查项管理
 */
@RestController
@RequestMapping("/checkItem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    //新增检查项
    @PostMapping("add")
    public Result<Object> addItem(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<Object>(false, MessageConstant.ADD_CHECKITEM_FAIL, null);
        }
        return new Result<>(true, MessageConstant.ADD_CHECKITEM_SUCCESS, null);
    }

    @PostMapping("findPage")
    public Result<PageResult<CheckItem>> findPage(@RequestBody QueryPageBean queryPageBean) {
        Result<PageResult<CheckItem>> result = null;
        try {
            result = checkItemService.findByPage(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(MessageConstant.QUERY_CHECKITEM_FAIL);
            result.setFlag(false);
            return result;
        }
        return result;
    }

    @DeleteMapping("delete/{id}")
    public Result<Object> delete(@PathVariable String id) {
        Result<Object> result = null;
        try {
            result = checkItemService.deleteById(id);
        } catch (Exception e) {
            return new Result<>(false, MessageConstant.DELETE_CHECKITEM_FAIL, null);
        }
        return result;
    }
}
