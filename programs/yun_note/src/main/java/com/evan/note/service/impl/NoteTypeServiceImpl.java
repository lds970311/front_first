// Author : evan lee
// Time ： 2022-03-04  0:03
// FILENAME : NoteTypeServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import com.evan.note.dao.NoteTypeDao;
import com.evan.note.dao.impl.NoteTypeDaoImpl;
import com.evan.note.pojo.NoteType;
import com.evan.note.service.NoteTypeService;
import com.evan.note.vo.ResultInfo;

import java.util.List;

public class NoteTypeServiceImpl implements NoteTypeService {
    private final NoteTypeDao noteTypeDao = new NoteTypeDaoImpl();

    @Override
    public List<NoteType> findTypeList(Integer id) {
        return noteTypeDao.getTypeListByUserId(id);
    }

    @Override
    public ResultInfo<NoteType> deleteType(String typeId) {
        ResultInfo<NoteType> resultInfo = new ResultInfo<>();
        if (typeId == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("typeId 不能为空!");
            return resultInfo;
        }
        int noteNum = noteTypeDao.findNoteNumByTypeId(typeId);
        if (noteNum > 0) {
            resultInfo.setCode(0);
            resultInfo.setMessage("该类型存在对应云记,不能删除!");
            return resultInfo;
        }
        int row = noteTypeDao.deleteNoteType(typeId);
        if (row == 0) {
            resultInfo.setCode(0);
            resultInfo.setMessage("删除失败!");
            return resultInfo;
        }
        resultInfo.setCode(1);
        resultInfo.setMessage("删除成功!");
        return resultInfo;
    }
}
