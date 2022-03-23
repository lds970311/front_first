// Author : evan lee
// Time ： 2022-03-21  19:33
// FILENAME : ServiceTest.java
// STATEMENT: 

package cn.evan.hotel;

import cn.evan.hotel.service.IHotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private IHotelService hotelService;

}
