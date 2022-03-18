// Author : evan lee
// Time ： 2022-03-17  19:46
// FILENAME : OrderSettring.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约设置
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSetting implements Serializable {
    private Integer id;
    private Date orderDate;//预约设置日期
    private int number;//可预约人数
    private int reservations;//已预约人数
}
