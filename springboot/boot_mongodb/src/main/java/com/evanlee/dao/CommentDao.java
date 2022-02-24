// Author : evan lee
// Time ： 2022-02-22  23:46
// FILENAME : CommentDao.java
// STATEMENT: 

package com.evanlee.dao;

import com.evanlee.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据父评论获取子评论, 并分页显示
     *
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
