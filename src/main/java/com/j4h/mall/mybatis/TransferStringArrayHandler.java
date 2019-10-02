package com.j4h.mall.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@MappedTypes(String[].class)
public class TransferStringArrayHandler implements TypeHandler<String[]> {
    private ObjectMapper objectMapper = new ObjectMapper();

    /*
    前端string[]-->传入到数据库里面以json格式string存储
    i：表示第几个参数
    strings：是前端传来的字符串数组
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        try {
            String s = objectMapper.writeValueAsString(strings);
            preparedStatement.setString(i, s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param resultSet
     * @param s:通过s可以得到数据库中的json格式的字符串数据
     * @return
     * @throws SQLException
     */
    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String value = resultSet.getString(s);
        return parseString2StringList(value);

    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String value = resultSet.getString(i);
        return parseString2StringList(value);

    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String value = callableStatement.getString(i);
        return parseString2StringList(value);
    }

    private String[] parseString2StringList(String value) {
        String[] strings = new String[0];
        if(value == null) {
            return strings;
        }
        try {
            strings = objectMapper.readValue(value, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
