// Author : evan lee
// Time ： 2022-02-11  14:08
// FILENAME : DynamicTest.java
// STATEMENT: 

package com.evan;

import com.evan.dao.EmpDynamicMapper;
import com.evan.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DynamicTest {

    public static SqlSessionFactory sqlSessionFactory;

    static {
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
    public void dynamicGet() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDynamicMapper mapper = sqlSession.getMapper(EmpDynamicMapper.class);
        Employee employee = mapper.getDynamicEmployee(new Employee(null, "jack", null, null));
        System.out.println(employee);
        //Employee(id=2, lastName=jack, gender=0, email=jack@123.com)
    }

    @Test
    public void dynamicUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDynamicMapper mapper = sqlSession.getMapper(EmpDynamicMapper.class);
        mapper.updateDynamicEmployee(new Employee(4, "Smith", null, null));
    }

    @Test
    public void getEmployeeByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDynamicMapper mapper = sqlSession.getMapper(EmpDynamicMapper.class);
        List<Employee> employees = mapper.getEmployees(Arrays.asList(1, 2, 3, 4));
        employees.forEach(System.out::println);
    }

}
