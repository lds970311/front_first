// Author : evan lee
// Time ： 2022-03-04  0:03
// FILENAME : NoteTypeServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import cn.hutool.core.util.StrUtil;
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

    @Override
    public ResultInfo<NoteType> addType(String typeName, Integer userId) {
        ResultInfo<NoteType> resultInfo = new ResultInfo<>();
        if (StrUtil.isBlank(typeName)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("类型名称不能为空!!");
            return resultInfo;
        }
        if (userId == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("未能获取到当前用户信息,添加失败!");
            return resultInfo;
        }
        //检查当前类别是否重复
        NoteType noteType = noteTypeDao.checkUnique(typeName, userId);
        if (noteType != null) {
            //重复了
            resultInfo.setCode(0);
            resultInfo.setMessage("当前类别已经存在,无法添加!");
            return resultInfo;
        }
        int row = noteTypeDao.addType(typeName, userId);
        if (row == 0) {
            resultInfo.setCode(0);
            resultInfo.setMessage("数据库异常,添加失败!");
            return resultInfo;
        }
        Integer typeId = noteTypeDao.getTypeId(typeName, userId);
        resultInfo.setCode(1);
        resultInfo.setMessage("添加类别成功!");
        resultInfo.setResult(new NoteType(typeId, typeName, userId));
        return resultInfo;
    }

    @Override
    public ResultInfo<NoteType> updateType(String typeName, String typeId, Integer userId) {
        ResultInfo<NoteType> resultInfo = new ResultInfo<>();
        if (StrUtil.isBlank(typeName)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("类型名称不能为空!!");
            return resultInfo;
        }
        if (StrUtil.isBlank(typeId)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("未能获取到当前类型信息,修改失败!");
            return resultInfo;
        }

        //检查当前类别是否重复
        NoteType noteType = noteTypeDao.checkUnique(typeName, userId);
        if (noteType != null) {
            //重复了
            resultInfo.setCode(0);
            resultInfo.setMessage("当前类别已经存在,无法修改!");
            return resultInfo;
        }
        int row = noteTypeDao.updateType(typeName, typeId);
        if (row == 0) {
            resultInfo.setCode(0);
            resultInfo.setMessage("数据库异常,添加失败!");
            return resultInfo;
        }
        //重新获取更新后的数据
        NoteType newType = noteTypeDao.getTypeByTypeId(typeId);
        resultInfo.setCode(1);
        resultInfo.setMessage("更新成功!");
        resultInfo.setResult(newType);
        return resultInfo;
    }
}
