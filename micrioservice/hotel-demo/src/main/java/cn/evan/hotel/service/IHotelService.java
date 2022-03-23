package cn.evan.hotel.service;

import cn.evan.hotel.pojo.Hotel;
import cn.evan.hotel.pojo.PageResult;
import cn.evan.hotel.pojo.RequestParams;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IHotelService extends IService<Hotel> {
    /**
     * 查询符合条件的酒店
     *
     * @param requestParams
     * @return
     */
    PageResult searchHotels(RequestParams requestParams);


    Map<String, List<String>> filters(RequestParams requestParams);

    List<String> getSuggestions(String key);

    void deleteById(Long id);

    void insertById(Long id);
}
