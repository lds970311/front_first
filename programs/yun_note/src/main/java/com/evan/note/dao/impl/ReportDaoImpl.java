// Author : evan lee
// Time ： 2022-03-07  0:10
// FILENAME : ReportDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.impl;

import com.evan.note.dao.ReportDao;
import com.evan.note.utils.JDBCUtils;
import com.evan.note.vo.LocationVo;

import java.util.List;

public class ReportDaoImpl implements ReportDao {

    @Override
    public List<String> getMonthByUserId(Integer userId) {
        String sql = "select distinct date_format(pubTime, '%Y年%m月')\n" +
                "from tb_note tn\n" +
                "inner join tb_note_type tnt on tn.typeId = tnt.typeId\n" +
                "where userId = ?\n" +
                "order by date_format(pubTime, '%Y年%m月') asc";
        return JDBCUtils.findStringList(sql, userId);
    }

    @Override
    public List<Integer> getNoteCountByMonth(Integer userId) {
        String sql = "select count(1)\n" +
                "from tb_note tn\n" +
                "         inner join tb_note_type tnt on tn.typeId = tnt.typeId\n" +
                "where userId = ?\n" +
                "group by date_format(pubTime, '%Y年%m月')\n" +
                "order by date_format(pubTime, '%Y年%m月')";
        return JDBCUtils.findIntegerList(sql, userId);
    }

    @Override
    public List<LocationVo> getLocations(Integer userId) {
        String sql = "select lon, lat\n" +
                "from tb_note\n" +
                "         left join tb_note_type tnt on tnt.typeId = tb_note.typeId\n" +
                "where userId = ?";
        return JDBCUtils.queryAll(LocationVo.class, sql, userId);
    }
}
