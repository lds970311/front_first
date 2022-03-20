// Author : evan lee
// Time ： 2022-03-20  20:41
// FILENAME : HotelController.java
// STATEMENT: 

package cn.evan.hotel.controller;

import cn.evan.hotel.pojo.PageResult;
import cn.evan.hotel.pojo.RequestParams;
import cn.evan.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @PostMapping("list")
    public PageResult listHotels(@RequestBody RequestParams requestParams) {
        return hotelService.searchHotels(requestParams);
    }
}
