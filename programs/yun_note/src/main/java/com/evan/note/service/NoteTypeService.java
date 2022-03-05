// Author : evan lee
// Time ： 2022-03-04  0:03
// FILENAME : NoteTypeService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.NoteType;
import com.evan.note.vo.ResultInfo;

import java.util.List;

@SuppressWarnings("all")
public interface NoteTypeService {
    /**
     * 查询类型列表
     *
     * @param id
     * @return
     */
    List<NoteType> findTypeList(Integer id);

    ResultInfo<NoteType> deleteType(String typeId);

    /**
     * 添加类型数据
     *
     * @param typeName
     * @param userId
     * @return
     */
    ResultInfo<NoteType> addType(String typeName, Integer userId);

    /**
     * 更新类型信息
     *
     * @param typeName
     * @param typeId
     * @param userId
     * @return
     */
    ResultInfo<NoteType> updateType(String typeName, String typeId, Integer userId);
}
