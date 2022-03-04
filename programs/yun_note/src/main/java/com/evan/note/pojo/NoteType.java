// Author : evan lee
// Time ： 2022-03-03  23:20
// FILENAME : NoteType.java
// STATEMENT: 

package com.evan.note.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteType {
    private Integer typeId;
    private String typeName;
    private Integer userId;
}
