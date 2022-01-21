// Author : evan lee
// Time ： 2022-01-21  16:49
// FILENAME : AllTest.java
// STATEMENT: 

package test;

import com.codewolf.dao.UserDaoImpl;
import com.codewolf.domain.User;
import com.codewolf.utils.MySQLUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class AllTest {
    @Test
    public void initTest() {
        System.out.println("hello");
    }

    @SneakyThrows
    @Test
    public void druidTest() {
        Connection connection = MySQLUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void findAllTest() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        all.forEach(System.out::println);
    }
}
