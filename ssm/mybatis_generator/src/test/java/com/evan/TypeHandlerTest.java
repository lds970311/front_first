// Author : evan lee
// Time ： 2022-02-12  22:31
// FILENAME : TypeHandlerTest.java
// STATEMENT: 

package com.evan;

import com.evan.mybatis.beans.EmpStatus;
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

public class TypeHandlerTest {
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
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee eillen = new Employee(null, "Eillen", "0", "eillen@gmail.com", 2);
        eillen.setEmpStatus(EmpStatus.LOGOUT);
        int insert = mapper.insert(eillen);
        System.out.println(insert);
    }
}
