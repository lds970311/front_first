// Author : evan lee
// Time ： 2022-03-07  0:09
// FILENAME : ReportService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.vo.LocationVo;
import com.evan.note.vo.ResultInfo;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface ReportService {

    /**
     * 查询当前用户下每月云记的数量
     *
     * @param userId
     * @return
     */
    ResultInfo<Map<String, Object>> getNoteCountByMonth(Integer userId);

    /**
     * 获取云记发布的位置信息
     *
     * @param userId
     * @return
     */
    List<LocationVo> getLocations(Integer userId);
}
