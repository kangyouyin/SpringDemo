package test.jdbc;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by kangyouyin on 2018/10/24.
 */
public class CacheService {
    public static Cache<String, JdbcTemplate> poiCache = CacheBuilder.newBuilder().build();

    @SuppressWarnings("unchecked")
    public static JdbcTemplate getJdbcTemplate(final String dbId) {
        JdbcTemplate template = null;
        try {
            template = poiCache.get(dbId, new Callable<JdbcTemplate>() {
                @Override
                public JdbcTemplate call(){
                    return getJdbcTemplateFromDB(dbId);
                }
            });
        } catch (ExecutionException e) {
            // 记日志
        }
        return Optional.fromNullable(template).or(new JdbcTemplate());
    }

    @SuppressWarnings("unchecked")
    private static JdbcTemplate getJdbcTemplateFromDB(String dbId){
        System.out.println("getting from DB, please wait...");
        JdbcTemplate template = null;
        try {

        } catch (Exception e) {
            // 记日志
        }
        return Optional.fromNullable(template).or(new JdbcTemplate());
    }
}
