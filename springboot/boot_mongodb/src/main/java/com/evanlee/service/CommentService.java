// Author : evan lee
// Time ： 2022-02-22  23:47
// FILENAME : CommentService.java
// STATEMENT: 

package com.evanlee.service;

import com.evanlee.dao.CommentDao;
import com.evanlee.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    /*** 保存一个评论 * @param comment */
    public void saveComment(Comment comment) {
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键 //设置一些默认初始值。。。
        commentDao.save(comment);
    }

    public void updateComment(Comment comment) {
        commentDao.save(comment);
    }

    public void deleteCommentById(String id) {
        commentDao.deleteById(id);
    }

    public List<Comment> findCommentList() {
        return commentDao.findAll();
    }

    public Comment findCommentById(String id) {
        return commentDao.findById(id)
                .get();
    }

    public Page<Comment> findCommentByPage(String parentId, int pageNo, int pageSize) {
        return commentDao.findByParentid(parentId, PageRequest.of(pageNo - 1, pageSize));
    }
}
