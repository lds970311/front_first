// Author : evan lee
// Time ： 2022-03-06  0:12
// FILENAME : NoteTypeVo.java
// STATEMENT: 

package com.evan.note.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteTypeVo {
    private Integer typeId;
    private Long noteCount;
    private String groupName;
}
