// Author : evan lee
// Time ： 2022-03-04  22:34
// FILENAME : NoteService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.Note;
import com.evan.note.utils.Page;
import com.evan.note.vo.NoteTypeVo;
import com.evan.note.vo.NoteVo;
import com.evan.note.vo.ResultInfo;

import java.util.List;

@SuppressWarnings("all")
public interface NoteService {

    /**
     * 添加日记
     *
     * @param typeId
     * @param title
     * @param content
     * @param lon
     * @param lat
     * @return
     */
    ResultInfo<Note> addNote(String typeId, String title, String content, String lon, String lat);

    /**
     * 分页查询云记
     *
     * @param pageNo
     * @param pageSize
     * @param userId
     * @param title
     * @param date
     * @param type
     * @return
     */
    Page<Note> findNoteListByPage(String pageNo, Integer pageSize, Integer userId, String title, String date, String type);

    /**
     * 根据用户id查询云记日期信息
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

    /**
     * 根据id查询对应云记
     *
     * @param parseInt
     * @return
     */
    Note findNoteById(int parseInt);

    /**
     * 根基typeid查询类型名称
     *
     * @param typeId
     * @return
     */
    String findNoteTypeByTypeId(int typeId);

    /**
     * 根据id删除日记
     *
     * @param parseInt
     * @return
     */
    ResultInfo<Note> deleteNoteById(Integer noteId);

    /**
     * 更新日记
     *
     * @param noteId
     * @param typeId
     * @param title
     * @param content
     * @return
     */
    ResultInfo<Note> updateNote(Integer noteId, String typeId, String title, String content);
}
