// Author : evan lee
// Time ： 2022-02-04  12:20
// FILENAME : AccountDaoImpl.java
// STATEMENT: 

package com.evan.transaction.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney() {
        String sql = "update jdbctemplate.account set  money=money-? where user=?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    @Override
    public void addMoney() {
        String sql = "update jdbctemplate.account set  money=money+? where user=?";
        jdbcTemplate.update(sql, 100, "mary");
    }
}
