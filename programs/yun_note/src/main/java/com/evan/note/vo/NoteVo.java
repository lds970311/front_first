// Author : evan lee
// Time ： 2022-03-05  23:48
// FILENAME : NoteVo.java
// STATEMENT: 

package com.evan.note.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteVo {
    private String groupName;
    private long noteCount;
}
