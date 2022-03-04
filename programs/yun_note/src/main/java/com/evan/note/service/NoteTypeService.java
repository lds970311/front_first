// Author : evan lee
// Time ： 2022-03-04  0:03
// FILENAME : NoteTypeService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.NoteType;
import com.evan.note.vo.ResultInfo;

import java.util.List;

public interface NoteTypeService {
    /**
     * 查询类型列表
     *
     * @param id
     * @return
     */
    List<NoteType> findTypeList(Integer id);

    ResultInfo<NoteType> deleteType(String typeId);
}
