package com.evan.boot_ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evan.boot_ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mechrevo
 * @description 针对表【book】的数据库操作Mapper
 * @createDate 2022-02-16 00:26:29
 * @Entity generator.domain.Book
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




