// Author : evan lee
// Time ： 2022-03-23  7:24
// FILENAME : PageResult.java
// STATEMENT: 

package cn.evanlee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    private Long total;//总记录数
    private List<T> rows;//当前页结果
}
