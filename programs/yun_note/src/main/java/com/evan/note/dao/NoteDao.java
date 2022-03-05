// Author : evan lee
// Time ： 2022-03-04  22:35
// FILENAME : NoteDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.pojo.Note;

public interface NoteDao {

    /**
     * 添加云记
     *
     * @param note
     * @return
     */
    int addNote(Note note);
}
