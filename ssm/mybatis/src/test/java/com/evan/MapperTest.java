// AUTHOR: CSR丶SUSE
// TIME : 2022-01-30  12:09
// FILENAME: MapperTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan;

import com.evan.dao.EmpMapper;
import com.evan.domain.Employee;
import com.evan.mybatis.MybatisHelloWord;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MapperTest {
    public static Logger logger = LoggerFactory.getLogger(MybatisHelloWord.class);

    public static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis.config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void mapperTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Employee employee = mapper.getEmployeeById(1);
        logger.info(employee.toString());
        sqlSession.close();
    }
}
