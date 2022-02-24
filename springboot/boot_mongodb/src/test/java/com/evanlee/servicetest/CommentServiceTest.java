// Author : evan lee
// Time ： 2022-02-22  23:53
// FILENAME : CommentServiceTest.java
// STATEMENT: 

package com.evanlee.servicetest;

import com.evanlee.pojo.Comment;
import com.evanlee.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    void getAllTest() {
        List<Comment> commentList = commentService.findCommentList();
        commentList.forEach(System.out::println);
    }

    @Test
    void testSave() {
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("今天天气不错");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("zl");
        comment.setParentid("3");
        comment.setState("1");
        comment.setLikenum(10);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    void getByIdTest() {
        Comment commentById = commentService.findCommentById("6215085d702d4231c213e212");
        System.out.println(commentById);
    }

    @Test
    void getByPageTest() {
        Page<Comment> commentByPage = commentService.findCommentByPage("3", 1, 2);
        commentByPage.getContent().forEach(System.out::println);
    }

    @Test
    void addLikeNumTest() {
        long l = commentService.updateCommentLikeNum("5");
        System.out.println(l);
    }
}
