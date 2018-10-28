package test.jdbc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kangyouyin on 2018/10/27.
 */
public class JdbcTemplateUtil {
    public static ConcurrentHashMap<String, Cache<String, JdbcTemplate>> jdbcTemplateCacheMap = new ConcurrentHashMap<>();

    public static JdbcTemplate getJdbcTemplate(String dbId) {
        Cache<String, JdbcTemplate> jdbcTemplateCache = null;
        //任务3：MD5加密
        //String dbId = "";
        if (jdbcTemplateCacheMap.containsKey(dbId)) {
            jdbcTemplateCache = jdbcTemplateCacheMap.get(dbId);
            if (jdbcTemplateCache == null) {
                jdbcTemplateCache = JdbcCacheUtil.createJdbcCache(dbId);
                jdbcTemplateCacheMap.put(dbId, jdbcTemplateCache);
            }
        } else {
            //首次连接
            jdbcTemplateCache = JdbcCacheUtil.createJdbcCache(dbId);
            jdbcTemplateCacheMap.put(dbId, jdbcTemplateCache);
        }
        return JdbcCacheUtil.getJdbcTemplate(jdbcTemplateCache, dbId);
    }
}
