// Author : evan lee
// Time ： 2022-03-04  22:34
// FILENAME : NoteService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.Note;
import com.evan.note.vo.ResultInfo;

@SuppressWarnings("all")
public interface NoteService {

    /**
     * 添加日记
     *
     * @param typeId
     * @param title
     * @param content
     * @return
     */
    ResultInfo<Note> addNote(String typeId, String title, String content);
}
