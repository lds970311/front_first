// Author : evan lee
// Time ： 2022-02-10  17:55
// FILENAME : ParamsTest.java
// STATEMENT: 

package com.evan;

import com.evan.dao.EmpMapper;
import com.evan.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ParamsTest {
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
    public void testGetEmpByIdAndName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Employee jack = mapper.getEmpByIdAndName(2, "jack");
        System.out.println(jack);
    }

    @Test
    public void testGetEmpsByLastNameLike() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> emps = mapper.getEmpsByLastNameLike("t");
        emps.forEach(System.out::println);
    }

    @Test
    public void testMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Map<String, Object> empMap = mapper.getEmpMap(1);
        empMap.forEach((s, o) -> {
            System.out.println(s + ":" + o);
        });
        /*
            gender:0
            last_name:tom
            id:1
            email:tom@gmail.com
         */
    }

    @Test
    public void testMaps() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Map<Integer, Employee> employeesMap = mapper.getEmployeesMap();
        employeesMap.forEach((integer, employee) -> {
            System.out.println(employee);
        });
    }
}
