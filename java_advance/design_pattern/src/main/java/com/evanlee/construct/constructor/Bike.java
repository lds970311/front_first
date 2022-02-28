// Author : evan lee
// Time ： 2022-02-28  16:14
// FILENAME : Bike.java
// STATEMENT: 

package com.evanlee.construct.constructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bike {
    private String frame;
    private String seat;
}
