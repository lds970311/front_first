// Author : evan lee
// Time ： 2022-03-04  0:04
// FILENAME : NoteTypeDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.impl;

import com.evan.note.dao.NoteTypeDao;
import com.evan.note.pojo.NoteType;
import com.evan.note.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class NoteTypeDaoImpl implements NoteTypeDao {

    @Override
    public List<NoteType> getTypeListByUserId(Integer id) {
        String sql = "select * from yun_note.tb_note_type where userId = ?";
        try {
            return JDBCUtils.queryAll(NoteType.class, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int findNoteNumByTypeId(String typeId) {
        String sql = "select count(*) from yun_note.tb_note where typeId = ?";
        return JDBCUtils.getRowCount(sql, typeId);
    }

    @Override
    public int deleteNoteType(String typeId) {
        String sql = "delete from yun_note.tb_note_type where typeId = ?";
        return JDBCUtils.update(sql, typeId);
    }
}
