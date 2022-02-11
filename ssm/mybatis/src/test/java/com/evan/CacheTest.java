// Author : evan lee
// Time ： 2022-02-11  17:51
// FILENAME : CacheTest.java
// STATEMENT: 

package com.evan;

import com.evan.dao.EmpMapper;
import com.evan.dao.EmpPlusMapper;
import com.evan.domain.Employee;
import com.evan.domain.EmployeePlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {
    public static SqlSessionFactory sqlSessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(CacheTest.class);

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
    public void testA() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpPlusMapper mapper = sqlSession.getMapper(EmpPlusMapper.class);
        EmployeePlus employee1 = mapper.getEmployeeById(1);
        //手动情况缓存
        sqlSession.clearCache();
        EmployeePlus employee2 = mapper.getEmployeeById(1);
        System.out.println(employee1 == employee2); //true
    }

    @Test
    public void level2CacheTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Employee employeeById = mapper.getEmployeeById(2);
        sqlSession.close();

        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        Employee employeeById1 = mapper1.getEmployeeById(2);
        System.out.println(employeeById1 == employeeById);
    }
}
