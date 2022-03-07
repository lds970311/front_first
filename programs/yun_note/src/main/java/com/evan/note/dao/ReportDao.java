// Author : evan lee
// Time ： 2022-03-07  0:09
// FILENAME : ReportDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.vo.LocationVo;

import java.util.List;

public interface ReportDao {

    List<String> getMonthByUserId(Integer userId);

    List<Integer> getNoteCountByMonth(Integer userId);

    List<LocationVo> getLocations(Integer userId);
}

