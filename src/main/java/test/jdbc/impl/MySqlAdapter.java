package test.jdbc.impl;

import com.alibaba.druid.pool.DruidDataSource;
import test.jdbc.IDbAdapter;

import javax.sql.DataSource;

/**
 * Created by kangyouyin on 2018/10/26.
 */
public class MySqlAdapter
        implements IDbAdapter {
    @Override
    public String getDbTypeName()
            throws RuntimeException {
        return "MYSQL";
    }

    @Override
    public Byte getDbTypeCode()
            throws RuntimeException {
        return (byte) 1;
    }

    @Override
    public String getSqlLimit(String strSql, int limitNum) {
        String strRet = "";
        strRet = strSql + " limit " + limitNum;
        return strRet;
    }

    @Override
    public String getDriver()
            throws RuntimeException {
        return "com.mysql.jdbc.Driver";
    }

    @Override
    public DataSource createDataSource()
            throws RuntimeException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.177.79:3306/kyy_test?characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}
