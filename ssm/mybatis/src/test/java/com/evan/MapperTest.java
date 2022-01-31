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
        Employee employee = mapper.getEmployeeById(3);
        logger.info(employee.toString());
        sqlSession.close();
    }

    @Test
    public void insertTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        boolean joel = mapper.addEmployee(new Employee(3, "louis", "0", "louis@111.com"));
        if (joel) {
            logger.info("insert success");
        } else {
            logger.warn("insert failed");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Integer updateEmployee = mapper.updateEmployee(new Employee(1, "sara", "1", "sara@111.com"));
        if (updateEmployee > 0) {
            logger.info("update success");
        } else {
            logger.warn("update failed");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Integer integer = mapper.deleteEmployee(3);
        if (integer > 0) {
            logger.info("delete success!");
        } else {
            logger.warn("delete failed!");
        }
        logger.info("delete success!");
        sqlSession.commit();
        sqlSession.close();
    }
}
