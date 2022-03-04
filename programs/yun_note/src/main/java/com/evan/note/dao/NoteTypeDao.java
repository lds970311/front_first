// Author : evan lee
// Time ： 2022-03-04  0:04
// FILENAME : NoteTypeDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.pojo.NoteType;

import java.util.List;

public interface NoteTypeDao {
    List<NoteType> getTypeListByUserId(Integer id);

    /**
     * 根据typeId查找对应云记数量
     *
     * @param typeId
     * @return
     */
    int findNoteNumByTypeId(String typeId);

    /**
     * 根据typeId删除云集类型
     *
     * @param typeId
     * @return
     */
    int deleteNoteType(String typeId);
}
