// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  23:45
// FILENAME: Order.java
// TOOLS : INTELLIJ IDEA
// STATEMENT:订单类


package com.evan.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 测试使用spring注入依赖
 */
public class Order {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String orderName;

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderName='" + orderName + '}';
    }
}
