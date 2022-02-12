// Author : evan lee
// Time ： 2022-02-12  22:49
// FILENAME : EmpSatusHandler.java
// STATEMENT: 

package com.evan.mybatis.typehandler;

import com.evan.mybatis.beans.EmpStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpStatusHandler implements TypeHandler<EmpStatus> {

    /**
     * 定义当前数据如何保存进数据库中
     *
     * @param preparedStatement
     * @param i
     * @param empStatus
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, EmpStatus empStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, empStatus.getCode().toString());
    }

    /**
     * 获取值
     *
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public EmpStatus getResult(ResultSet resultSet, String s) throws SQLException {
        //需要根据从数据库拿到的枚举的信息,返回一个枚举对象
        int msg = resultSet.getInt(s);
        System.out.println("数据库中的状态码:" + msg);
        return EmpStatus.getStatusByCode(msg);
    }

    /**
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EmpStatus getResult(ResultSet resultSet, int i) throws SQLException {
        int msg = resultSet.getInt(i);
        System.out.println("数据库中的状态码:" + msg);
        return EmpStatus.getStatusByCode(msg);
    }

    /**
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public EmpStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        System.out.println("数据库中的状态码:" + code);
        return EmpStatus.getStatusByCode(code);
    }
}
