// Author : evan lee
// Time ： 2022-03-07  0:09
// FILENAME : ReportServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import com.evan.note.dao.ReportDao;
import com.evan.note.dao.impl.ReportDaoImpl;
import com.evan.note.service.ReportService;
import com.evan.note.vo.LocationVo;
import com.evan.note.vo.ResultInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private final ReportDao reportDao = new ReportDaoImpl();

    @Override
    public ResultInfo<Map<String, Object>> getNoteCountByMonth(Integer userId) {
        ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();
        if (userId == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("系统异常,请稍后再试!");
            return resultInfo;
        }
        Map<String, Object> result = new HashMap<>();
        //查询对应月份信息
        List<String> monthList = reportDao.getMonthByUserId(userId);
        //查询每月对应的云记数量
        List<Integer> monthData = reportDao.getNoteCountByMonth(userId);
        result.put("monthList", monthList);
        result.put("monthData", monthData);

        resultInfo.setResult(result);
        resultInfo.setCode(1);
        resultInfo.setMessage("success!");
        return resultInfo;
    }

    @Override
    public List<LocationVo> getLocations(Integer userId) {
        return reportDao.getLocations(userId);
    }
}
