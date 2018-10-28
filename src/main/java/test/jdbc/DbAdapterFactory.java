package test.jdbc;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kangyouyin on 2018/10/26.
 */
public class DbAdapterFactory {
    private static Logger logger = Logger.getLogger(DbAdapterFactory.class);

    /**
     * 数据库适配器
     */
    public final static Map<Byte, String> dbType = new HashMap<Byte, String>() {
        private static final long serialVersionUID = 1L;

        {
            put((byte)1, "test.jdbc.impl.MySqlAdapter");
        }
    };

    /**
     * Description: 初始化DataBaseAdapter
     *
     * @param dbTypeCode
     * @return
     */
    public static IDbAdapter dbAdapterInit(Byte dbTypeCode) {
        try {
            String clsName = dbType.get(dbTypeCode);
            Class<?> cls;
            cls = Class.forName(clsName);
            return (IDbAdapter) cls.newInstance();
        } catch (ClassNotFoundException e) {
            logger.error("get database adapter init ClassNotFoundException：", e);
        } catch (InstantiationException e) {
            logger.error("get database adapter init InstantiationException：", e);
        } catch (IllegalAccessException e) {
            logger.error("get database adapter init IllegalAccessException：", e);
        }
        logger.debug("get database adapter init fail,return null.");
        return null;
    }
}
