// Author : evan lee
// Time ： 2022-03-23  7:03
// FILENAME : TravelGroup.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 报团进行分组
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelGroup implements Serializable {
    private Integer id;//主键
    private String code;//旅行团项目编号
    private String name;//旅行团名称
    private String helpCode;//旅行团项目缩写
    private String sex;//适用性别
    private String remark;//介绍
    private String attention;//注意事项
    private List<TravelItem> travelItems;//一个报团包含多个自由行
}
