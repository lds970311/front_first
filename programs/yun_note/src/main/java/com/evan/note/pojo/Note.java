// Author : evan lee
// Time ： 2022-03-04  22:32
// FILENAME : Note.java
// STATEMENT: 

package com.evan.note.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Integer noteId;
    private String title; //标题
    private String content; //内容
    private Integer typeId; //类型
    private Date pubTime;
    private Float lon;
    private Float lat;
}
