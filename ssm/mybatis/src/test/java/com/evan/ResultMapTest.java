// Author : evan lee
// Time ： 2022-02-10  22:20
// FILENAME : ResultMapTest.java
// STATEMENT: 

package com.evan;

import com.evan.dao.EmpPlusMapper;
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

public class ResultMapTest {
    public static SqlSessionFactory sqlSessionFactory;
    public static Logger logger = LoggerFactory.getLogger(ResultMapTest.class);

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
    public void testResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpPlusMapper mapper = sqlSession.getMapper(EmpPlusMapper.class);
        EmployeePlus employeeById = mapper.getEmployeeById(1);
        System.out.println(employeeById);
        //System.out.println(employeeById.getDepartment());
    }

    @Test
    public void testStep() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpPlusMapper mapper = sqlSession.getMapper(EmpPlusMapper.class);
        EmployeePlus employeeByStep = mapper.getEmployeeByStep(3);
        logger.warn(employeeByStep.toString());
        System.out.println(employeeByStep);
        //System.out.println(employeeById.getDepartment());
    }
}
