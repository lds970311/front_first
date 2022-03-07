// Author : evan lee
// Time ： 2022-03-04  22:34
// FILENAME : NoteServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import com.evan.note.dao.NoteDao;
import com.evan.note.dao.impl.NoteDaoImpl;
import com.evan.note.pojo.Note;
import com.evan.note.service.NoteService;
import com.evan.note.utils.Page;
import com.evan.note.vo.NoteTypeVo;
import com.evan.note.vo.NoteVo;
import com.evan.note.vo.ResultInfo;

import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class NoteServiceImpl implements NoteService {
    private final NoteDao noteDao = new NoteDaoImpl();

    @Override
    public ResultInfo<Note> addNote(String typeId, String title, String content, String lon, String lat) {
        ResultInfo<Note> resultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeId)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记类型不能为空!");
            return resultInfo;
        }

        if (StrUtil.isBlank(title)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记标题不能为空!");
            return resultInfo;
        }

        if (StrUtil.isBlank(content)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记内容不能为空!");
            return resultInfo;
        }
        //设置回显对象
        Note note = new Note();
        note.setTypeId(Integer.parseInt(typeId));
        note.setTitle(title);
        note.setContent(content);
        note.setPubTime(new Date());
        //如果没有经纬度,默认设置为北京
        if (StrUtil.isBlank(lon) || StrUtil.isBlank(lat)) {
            note.setLon(116.404f);
            note.setLat(39.915f);
        } else {
            note.setLon(Float.parseFloat(lon));
            note.setLat(Float.parseFloat(lat));
        }
        //添加云记记录
        int row = noteDao.addNote(note);

        if (row == 0) {
            //添加失败
            resultInfo.setCode(0);
            resultInfo.setMessage("云记添加失败!");
            resultInfo.setResult(note);
            return resultInfo;
        }
        //成功
        resultInfo.setCode(1);
        resultInfo.setMessage("添加云记成功!!");
        return resultInfo;
    }

    @Override
    public Page<Note> findNoteListByPage(String pageNo, Integer pageSize, Integer userId, String title, String date, String type) {
        Integer defaultNo = 1;
        Integer defaultSize = 5;
        if (!StrUtil.isBlank(pageNo)) {
            defaultNo = Integer.parseInt(pageNo);
        }
        if (pageSize != null) {
            defaultSize = pageSize;
        }
        //查询记录总数
        int count = noteDao.getNoteCountByUserId(userId, title, date, type);
        if (count < 1) {
            return null;
        }
        Page<Note> notePage = new Page<Note>(defaultNo, defaultSize, count);
        //得到分页开始下标
        int startIndex = (defaultNo - 1) * defaultSize;
        List<Note> noteList = noteDao.findNoteListByPage(userId, startIndex, pageSize, title, date, type);
        notePage.setDataList(noteList);
        return notePage;
    }

    @Override
    public List<NoteVo> findNoteCountByDate(Integer userId) {
        return noteDao.findNoteCountByDate(userId);
    }

    @Override
    public List<NoteTypeVo> findNoteCountByType(Integer userId) {
        return noteDao.findNoteCountByType(userId);
    }

    @Override
    public Note findNoteById(int parseInt) {
        return noteDao.findNoteById(parseInt);
    }

    @Override
    public String findNoteTypeByTypeId(int typeId) {
        return noteDao.findNoteTypeByTypeId(typeId);
    }

    @Override
    public ResultInfo<Note> deleteNoteById(Integer noteId) {
        ResultInfo<Note> resultInfo = new ResultInfo<>();
        if (noteId == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("服务器异常,请稍后重试!");
            return resultInfo;
        }
        int row = noteDao.deleteNoteById(noteId);
        if (row == 0) {
            resultInfo.setCode(0);
            resultInfo.setMessage("删除云记失败!");
            return resultInfo;
        }
        resultInfo.setCode(1);
        resultInfo.setMessage("删除成功!");
        return resultInfo;
    }

    @Override
    public ResultInfo<Note> updateNote(Integer noteId, String typeId, String title, String content) {
        ResultInfo<Note> resultInfo = new ResultInfo<>();
        if (noteId == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("服务器异常,请稍后修改!");
            return resultInfo;
        }


        if (StrUtil.isBlank(typeId)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记类型不能为空!");
            return resultInfo;
        }

        if (StrUtil.isBlank(title)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记标题不能为空!");
            return resultInfo;
        }

        if (StrUtil.isBlank(content)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("云记内容不能为空!");
            return resultInfo;
        }
        //设置回显对象
        Note note = new Note();
        note.setTypeId(Integer.parseInt(typeId));
        note.setTitle(title);
        note.setContent(content);
        note.setNoteId(noteId);

        //更新云记记录
        int row = noteDao.updateNote(note);

        if (row == 0) {
            //添加失败
            resultInfo.setCode(0);
            resultInfo.setMessage("云记更新失败!");
            resultInfo.setResult(note);
            return resultInfo;
        }
        //成功
        resultInfo.setCode(1);
        resultInfo.setMessage("更新云记成功!!");
        return resultInfo;
    }
}
