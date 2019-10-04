package com.j4h.mall.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(int[].class)
public class TransferIntArrayHandler implements TypeHandler<int[]> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, int[] ints, JdbcType jdbcType) throws SQLException {
        try {
            String s = objectMapper.writeValueAsString(ints);
            preparedStatement.setString(i, s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return parseString2IntArray(string);
    }

    @Override
    public int[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return parseString2IntArray(string);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return parseString2IntArray(string);
    }


    private int[] parseString2IntArray(String value) {
        int[] ints = new int[0];
        if(value == null) {
            return ints;
        }
        try {
            ints = objectMapper.readValue(value, int[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ints;
    }
}
