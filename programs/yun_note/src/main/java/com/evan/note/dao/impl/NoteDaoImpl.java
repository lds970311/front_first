// Author : evan lee
// Time ： 2022-03-04  22:35
// FILENAME : NoteDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.impl;

import com.evan.note.dao.NoteDao;
import com.evan.note.pojo.Note;
import com.evan.note.utils.JDBCUtils;

public class NoteDaoImpl implements NoteDao {

    @Override
    public int addNote(Note note) {
        String sql = "insert into yun_note.tb_note(title,content,typeId,pubTime,lon,lat) values" +
                "(?,?,?,?,?,?)";
        return JDBCUtils.update(sql, note.getTitle(), note.getContent(), note.getTypeId(),
                note.getPubTime(), note.getLon(), note.getLat());
    }
}
