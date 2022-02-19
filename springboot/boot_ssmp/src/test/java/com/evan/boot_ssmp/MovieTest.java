// Author : evan lee
// Time ： 2022-02-19  19:38
// FILENAME : MovieTest.java
// STATEMENT: 

package com.evan.boot_ssmp;

import com.evan.boot_ssmp.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {
    @Autowired
    private Movie movie;

    @Test
    void movieTest() {
        System.out.println(movie);
    }
}
