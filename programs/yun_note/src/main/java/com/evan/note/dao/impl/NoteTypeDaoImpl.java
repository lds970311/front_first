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
        return JDBCUtils.queryAll(NoteType.class, sql, id);
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

    @Override
    public int addType(String typeName, Integer userId) {
        String sql = "insert into yun_note.tb_note_type (typeName, userId) values(?,?)";
        return JDBCUtils.update(sql, typeName, userId);
    }

    @Override
    public NoteType checkUnique(String typeName, Integer userId) {
        String sql = "select * from yun_note.tb_note_type where typeName=? and userId=?";
        return JDBCUtils.queryOne(NoteType.class, sql, typeName, userId);
    }

    @Override
    public Integer getTypeId(String typeName, Integer userId) {
        String sql = "select typeId from yun_note.tb_note_type where typeName=? and userId=?";
        return JDBCUtils.getRowCount(sql, typeName, userId);
    }

    @Override
    public int updateType(String typeName, String typeId) {
        String sql = "update yun_note.tb_note_type set typeName = ? where typeId = ?";
        return JDBCUtils.update(sql, typeName, typeId);
    }

    @Override
    public NoteType getTypeByTypeId(String typeId) {
        String sql = "select * from yun_note.tb_note_type where typeId = ?";
        return JDBCUtils.queryOne(NoteType.class, sql, typeId);
    }
}
