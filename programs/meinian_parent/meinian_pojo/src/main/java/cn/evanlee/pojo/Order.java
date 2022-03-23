// Author : evan lee
// Time ： 2022-03-23  6:59
// FILENAME : Order.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 。旅行团订单(预约)信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    public static final String ORDERTYPE_TELEPHONE = "电话预约";
    public static final String ORDERTYPE_WEIXIN = "微信预约";
    public static final String ORDERSTATUS_YES = "已出游";
    public static final String ORDERSTATUS_NO = "未出游";
    private Integer id;
    private Integer memberId;//会员id
    private Date orderDate;//预约日期
    private String orderType;//预约类型 电话预约/微信预约
    private String orderStatus;//预约状态（是否出游）
    private Integer setmealId;//旅行套餐id
}
