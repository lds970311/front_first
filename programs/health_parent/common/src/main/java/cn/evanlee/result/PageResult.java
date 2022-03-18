// Author : evan lee
// Time ： 2022-03-17  20:01
// FILENAME : PageResult.java
// STATEMENT: 

package cn.evanlee.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {
    private Long total;//总记录数
    private List<T> rows;//当前页结果
}
