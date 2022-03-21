// Author : evan lee
// Time ： 2022-03-20  20:41
// FILENAME : HotelController.java
// STATEMENT: 

package cn.evan.hotel.controller;

import cn.evan.hotel.pojo.PageResult;
import cn.evan.hotel.pojo.RequestParams;
import cn.evan.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @PostMapping("list")
    public PageResult listHotels(@RequestBody RequestParams requestParams) {
        return hotelService.searchHotels(requestParams);
    }

    @PostMapping("filters")
    public Map<String, List<String>> filters(@RequestBody RequestParams requestParams) {
        return hotelService.filters(requestParams);
    }

    @GetMapping("suggestion")
    public List<String> getSuggestions(@RequestParam("key") String key) {
        return hotelService.getSuggestions(key);
    }
}
