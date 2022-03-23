// Author : evan lee
// Time ： 2022-03-23  7:25
// FILENAME : QueryPageBean.java
// STATEMENT: 

package cn.evanlee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryPageBean implements Serializable {
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数
    private String queryString;//查询条件
}
