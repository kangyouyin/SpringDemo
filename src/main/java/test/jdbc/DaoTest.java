package test.jdbc;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by kangyouyin on 2018/10/24.
 */
public class DaoTest {
    public static Cache<String, String> poiCache = CacheBuilder.newBuilder().build();

    @SuppressWarnings("unchecked")
    public static String getPOIList(final String dbId) {
//        JdbcTemplate template = null;
        String template = "";
        try {
            template = poiCache.get(dbId, new Callable<String>() {
                @Override
                public String call(){
                    return getPOIListFromDB(dbId);
                }
            });
        } catch (ExecutionException e) {
            // 记日志
        }
        return Optional.fromNullable(template).or("");
    }

    @SuppressWarnings("unchecked")
    private static String getPOIListFromDB(String dbId){
        System.out.println("getting from DB, please wait...");
//        JdbcTemplate template = null;
        String template = "";
        // 模仿从数据库中取数据
        try {
            Thread.sleep(1000);
            switch (dbId){
                case "0101" :
                    template = "mysql";
                    break;
                case "0102" :
                    template = "oracle";
                    break;
            }
        } catch (Exception e) {
            // 记日志
        }
        return Optional.fromNullable(template).or("");
    }
}
