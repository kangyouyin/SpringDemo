package test.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Created by kangyouyin on 2018/10/24.
 */
public class DruidTest {
    public static void main(String[] args) {
        try {

            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://192.168.177.79:3306/kyy_test?characterEncoding=UTF8");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

            JdbcTemplate template = new JdbcTemplate();
            template.setDataSource(dataSource);

            String sql = "select count(*) from user_info";
            System.out.println(sql);
            SqlRowSet sqlRowSet = template.queryForRowSet(sql);

            System.out.println(sqlRowSet.getInt(0));
            dataSource.cloneDruidDataSource();
            dataSource.close();
        } catch (Exception e) {

        }
    }
}
