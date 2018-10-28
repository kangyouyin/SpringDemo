package test.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;



/**
 * Created by kangyouyin on 2018/10/24.
 */
public class DruidDataSourceFactory {
    public static DataSource createDataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        return dataSource;
    }
}
