// Author : evan lee
// Time ： 2022-03-04  0:04
// FILENAME : NoteTypeDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.pojo.NoteType;

import java.util.List;

@SuppressWarnings("all")
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

    /**
     * 添加类型
     *
     * @param typeName
     * @param userId
     * @return
     */
    int addType(String typeName, Integer userId);

    /**
     * 类型检查唯一性
     *
     * @param typeName
     * @param userId
     * @return
     */
    NoteType checkUnique(String typeName, Integer userId);

    /**
     * 获取TypeId
     *
     * @param typeName
     * @param userId
     * @return
     */
    Integer getTypeId(String typeName, Integer userId);

    /**
     * 更新类型信息
     *
     * @param typeName
     * @param typeId
     * @return
     */
    int updateType(String typeName, String typeId);

    /**
     * 根据typeId查询对应类型
     *
     * @param typeId
     * @return
     */
    NoteType getTypeByTypeId(String typeId);
}
