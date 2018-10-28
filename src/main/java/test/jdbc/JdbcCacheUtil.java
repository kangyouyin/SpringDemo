package test.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by kangyouyin on 2018/10/28.
 */
public class JdbcCacheUtil {

    public static Cache<String, JdbcTemplate> createJdbcCache(String dbId) {
        JdbcTemplate jdbcTemplate = createJdbcTemplate(dbId);
        //任务2：设置过期时间
        Cache<String, JdbcTemplate> jdbcTemplateCache = CacheBuilder.newBuilder().build();
        jdbcTemplateCache.put(dbId, jdbcTemplate);

        return jdbcTemplateCache;
    }

    public static JdbcTemplate getJdbcTemplate(Cache<String, JdbcTemplate> jdbcTemplateCache, final String dbId) {
        JdbcTemplate jdbcTemplate = null;
        try {
            jdbcTemplate = jdbcTemplateCache.get(dbId, new Callable<JdbcTemplate>() {
                @Override
                public JdbcTemplate call() {
                    return createJdbcTemplate(dbId);
                }
            });
        } catch (ExecutionException e) {
            // 记日志
        }
        return jdbcTemplate;
    }

    public static JdbcTemplate createJdbcTemplate(String dbId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //任务1：获取不同数据库的dataSource
        byte dbtype = 1;
        DataSource dataSource = DbAdapterFactory.dbAdapterInit(dbtype).createDataSource();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
