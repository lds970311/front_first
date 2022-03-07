// Author : evan lee
// Time ： 2022-03-04  22:35
// FILENAME : NoteDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.evan.note.dao.NoteDao;
import com.evan.note.pojo.Note;
import com.evan.note.utils.JDBCUtils;
import com.evan.note.vo.NoteTypeVo;
import com.evan.note.vo.NoteVo;

import java.util.List;

public class NoteDaoImpl implements NoteDao {

    @Override
    public int addNote(Note note) {
        String sql = "insert into yun_note.tb_note(title,content,typeId,pubTime,lon,lat) values" +
                "(?,?,?,?,?,?)";
        return JDBCUtils.update(sql, note.getTitle(), note.getContent(), note.getTypeId(),
                note.getPubTime(), note.getLon(), note.getLat());
    }

    @Override
    public int getNoteCountByUserId(Integer userId, String title, String date, String type) {
        String sql = "select count(1) from tb_note n\n" +
                "inner join tb_note_type tnt on n.typeId = tnt.typeId\n" +
                "where tnt.userId = ?";
        if (!StrUtil.isBlank(title)) {
            //如果查询参数不为空,则拼接sql,设置所需要的参数
            sql += " and title like concat('%',?,'%')";
            return JDBCUtils.getRowCount(sql, userId, title);
        } else if (!StrUtil.isEmpty(date)) {
            sql += " and date_format(pubTime,'%Y年%m月') = ?";
            return JDBCUtils.getRowCount(sql, userId, date);
        } else if (!StrUtil.isBlank(type)) {
            int typeId = Integer.parseInt(type);
            sql += " and n.typeId = ?";
            return JDBCUtils.getRowCount(sql, userId, typeId);
        }
        return JDBCUtils.getRowCount(sql, userId);
    }

    @Override
    public List<Note> findNoteListByPage(int userId, Integer startIndex, Integer pageSize, String title, String date, String type) {
        String sql = "select n.noteId, n.title, n.content, n.typeId, n.pubTime, n.lon, n.lat\n" +
                "from tb_note n\n" +
                "         inner join tb_note_type tnt on n.typeId = tnt.typeId\n" +
                "where tnt.userId = ?";
        if (!StrUtil.isBlank(title)) {
            sql += " and title like concat('%',?,'%') limit ?,?";
            return JDBCUtils.queryAll(Note.class, sql, userId, title, startIndex, pageSize);
        } else if (!StrUtil.isEmpty(date)) {
            sql += " and date_format(pubTime,'%Y年%m月') = ? limit ?,?";
            return JDBCUtils.queryAll(Note.class, sql, userId, date, startIndex, pageSize);
        } else if (!StrUtil.isBlank(type)) {
            int typeId = Integer.parseInt(type);
            sql += " and n.typeId = ? limit ?,?";
            return JDBCUtils.queryAll(Note.class, sql, userId, typeId, startIndex, pageSize);
        }
        sql += " limit ?,?";
        return JDBCUtils.queryAll(Note.class, sql, userId, startIndex, pageSize);
    }

    @Override
    public List<NoteVo> findNoteCountByDate(Integer userId) {
        String sql = "select date_format(pubTime, '%Y年%m月') as `groupName`, count(1) as noteCount\n" +
                "from tb_note n\n" +
                "         inner join tb_note_type tnt on n.typeId = tnt.typeId\n" +
                "where userId = ?\n" +
                "group by date_format(pubTime, '%Y年%m月')\n" +
                "order by groupName desc;";
        return JDBCUtils.queryAll(NoteVo.class, sql, userId);
    }

    @Override
    public List<NoteTypeVo> findNoteCountByType(Integer userId) {
        String sql = "select tn.typeId, count(1) as noteCount, tnt.typeName as groupName from tb_note tn\n" +
                "inner join tb_note_type tnt on tn.typeId = tnt.typeId\n" +
                "where tnt.userId = ?\n" +
                "group by tnt.typeName\n" +
                "order by noteCount desc";
        return JDBCUtils.queryAll(NoteTypeVo.class, sql, userId);
    }

    @Override
    public Note findNoteById(int parseInt) {
        String sql = "select * from tb_note where noteId = ?";
        return JDBCUtils.queryOne(Note.class, sql, parseInt);
    }

    @Override
    public String findNoteTypeByTypeId(int typeId) {
        String sql = "select typeName from tb_note_type where typeId = ?";
        return JDBCUtils.findSingleValue(sql, typeId);
    }

    @Override
    public int deleteNoteById(Integer noteId) {
        String sql = "delete from tb_note where noteId = ?";
        return JDBCUtils.update(sql, noteId);
    }

    @Override
    public int updateNote(Note note) {
        String sql = "update tb_note set title = ?,content = ?,typeId = ? where noteId = ?";
        return JDBCUtils.update(sql, note.getTitle(), note.getContent(), note.getTypeId(), note.getNoteId());
    }
}
