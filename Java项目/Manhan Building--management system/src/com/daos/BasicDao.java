package com.daos;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class BasicDao {
    static QueryRunner query = new QueryRunner();
    static Properties pro = new Properties();

    static
    {
        try
        {
            pro.load(new FileInputStream("src/druid.properties"));
            druid = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    static DataSource druid;
    static Connection con;

    //dml语句,增删改
    public static int update(String sql, Object... params)
    {

        try
        {
            con = druid.getConnection();
            int rows = query.update(con, sql, params);
            con.close();
            return rows;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    //多行查询
    public static <T> List<T> selectMulti(String sql, Class<T> clazz, Object... params)
    {
        try
        {
            con = druid.getConnection();
            List<T> rows = query.query(con, sql, new BeanListHandler<T>(clazz), params);
            con.close();
            return rows;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    //单行查询
    public static <T> T selectSingle(String sql, Class<T> clazz, Object... params)
    {
        try
        {
            con = druid.getConnection();
            T row = query.query(con, sql, new BeanHandler<T>(clazz), params);
            con.close();
            return row;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    //单行单列查询
    public static Object selectOne(String sql, Object... params)
    {
        try
        {
            con = druid.getConnection();
            Object obj = query.query(con, sql, new ScalarHandler<>(), params);
            con.close();
            return obj;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Connection start()
    {
        try
        {
            con = druid.getConnection();
            con.setAutoCommit(false);
            return con;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static int execute( Connection con,String sql, Object... params)
    {
        try
        {
            int rows = query.update(con, sql, params);
            return rows;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con)
    {
        try
        {
            con.commit();
            con.close();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
