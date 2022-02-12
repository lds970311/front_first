// Author : evan lee
// Time ： 2022-02-11  22:40
// FILENAME : MybatisTest.java
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

public class MybatisTest {
    private static final SqlSessionFactory sqlSessionFactory;

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
    public void getAllEmps() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Employee> allEmployees = mapper.getAllEmployees();
        allEmployees.forEach(System.out::println);
    }
}
