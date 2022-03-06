// Author : evan lee
// Time ： 2022-03-04  22:35
// FILENAME : NoteDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.pojo.Note;
import com.evan.note.vo.NoteTypeVo;
import com.evan.note.vo.NoteVo;

import java.util.List;

@SuppressWarnings("all")
public interface NoteDao {

    /**
     * 添加云记
     *
     * @param note
     * @return
     */
    int addNote(Note note);

    /**
     * 获取对应用户的云记数量
     *
     * @param userId
     * @param title
     * @return
     */
    int getNoteCountByUserId(Integer userId, String title);

    /**
     * 分页数据
     *
     * @param defaultSize
     * @param size
     * @param startIndex
     * @param title
     * @return userId, startIndex, pageSize
     */
    List<Note> findNoteListByPage(int userId, Integer startIndex, Integer pageSize, String title);

    /**
     * 查询每个月份对应的日记数量
     *
     * @param userId
     * @return
     */
    List<NoteVo> findNoteCountByDate(Integer userId);

    /**
     * 查询当前用户霞各个分类的云记数量
     *
     * @param userId
     * @return
     */
    List<NoteTypeVo> findNoteCountByType(Integer userId);
}
