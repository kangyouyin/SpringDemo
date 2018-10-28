package test.jdbc;

import javax.sql.DataSource;

/**
 * Created by kangyouyin on 2018/10/26.
 */
public interface IDbAdapter {
    /**
     * 得到数据库类型名称
     *
     * @return
     * @throws RuntimeException
     */
    String getDbTypeName()
            throws RuntimeException;

    /**
     * 得到数据库类型代号
     *
     * @return
     * @throws RuntimeException
     */
    Byte getDbTypeCode()
            throws RuntimeException;

    /**
     * 取得DBMS生成限制返回前N条记录条的SQL
     *
     * @param limitNum 限制返回条数
     * @return 函数
     * @throws RuntimeException 不支持此类DBMS
     */
    String getSqlLimit(String strSql, int limitNum)
            throws RuntimeException;

    /**
     * 得到数据库类型
     *
     * @return
     * @throws RuntimeException
     */
    String getDriver()
            throws RuntimeException;

    /**
     * 创建DataSource
     *
     * @return
     * @throws RuntimeException
     */
    DataSource createDataSource()
            throws RuntimeException;
}
