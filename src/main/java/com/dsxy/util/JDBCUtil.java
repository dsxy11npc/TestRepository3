package com.dsxy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtil {
    //维护连接池
    private static DataSource dataSource;
    //线程连接
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    //项目启动初始化
    static{
        try {
            //创建properties对象
            Properties prop = new Properties();
            //获取配置
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(inputStream);
            //druid连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //获取连接
    public static Connection getConnection(){
        //从线程连接里获取
        Connection connection = threadLocal.get();
        //如果线程里没有连接--第一次获取
        if(connection==null){
            try {
                //创建一个连接，并且存放在线程里面
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set(connection);
        }
        return connection;
    }

    //回收连接
    public static void release(){
        //获取连接，如果不为空则需要释放
        Connection connection = threadLocal.get();
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //移除
            threadLocal.remove();
        }
    }
}
