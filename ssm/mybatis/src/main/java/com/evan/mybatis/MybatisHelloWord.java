// Author : evan lee
// Time ： 2022-01-28  1:55
// FILENAME : MybatisHelloWord.java
// STATEMENT: 

package com.evan.mybatis;


import com.evan.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisHelloWord {
    public static Logger logger = LoggerFactory.getLogger(MybatisHelloWord.class);

    public static void main(String[] args) {
        String resource = "mybatis.config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.sqlSession能直接执行已经映射的sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = sqlSession.selectOne("com.evan.dao.EmpMapper.getEmployeeById", 1);
        logger.info(employee.toString());
        sqlSession.close();
    }
}
