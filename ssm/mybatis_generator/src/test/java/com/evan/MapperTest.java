// Author : evan lee
// Time ： 2022-02-12  11:43
// FILENAME : MapperTest.java
// STATEMENT: 

package com.evan;

import com.evan.mybatis.beans.Employee;
import com.evan.mybatis.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

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

    @Test
    public void pageTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Page<Object> pageInfo = PageHelper.startPage(1, 4);
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        List<Employee> employees = mapper.getAllEmployees();
        employees.forEach(System.out::println);
    }

    @Test
    public void batchInsertTest() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            String all = "abcdfghijklmnopqrstuvwxyz";
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    stringBuilder.append(all.charAt(random.nextInt(all.length())));
                }
                mapper.insert(new Employee(null, stringBuilder.toString(), "1", stringBuilder + "126.com", null));
                sqlSession.commit();
            }
        }
    }
}
