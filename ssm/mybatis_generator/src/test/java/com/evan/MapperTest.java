// Author : evan lee
// Time ： 2022-02-12  11:43
// FILENAME : MapperTest.java
// STATEMENT: 

package com.evan;

import com.evan.mybatis.beans.Employee;
import com.evan.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MapperTest {
    private static SqlSessionFactory sqlSessionFactory;


    @BeforeAll
    public static void initResource() {
        String resource = "mybatis.config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void employeeTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectByPrimaryKey(1);
        System.out.println(employee);
    }
}
