// Author : evan lee
// Time ： 2022-03-20  20:40
// FILENAME : PageResult.java
// STATEMENT: 

package cn.evan.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Long total;
    private List<HotelDoc> hotels;
}
