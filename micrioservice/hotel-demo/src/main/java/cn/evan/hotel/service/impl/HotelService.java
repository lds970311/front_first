package cn.evan.hotel.service.impl;

import cn.evan.hotel.mapper.HotelMapper;
import cn.evan.hotel.pojo.Hotel;
import cn.evan.hotel.service.IHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
