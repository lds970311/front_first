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
import com.evan.note.vo.ResultInfo;

public class NoteServiceImpl implements NoteService {
    private final NoteDao noteDao = new NoteDaoImpl();

    @Override
    public ResultInfo<Note> addNote(String typeId, String title, String content) {
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
}
