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
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
