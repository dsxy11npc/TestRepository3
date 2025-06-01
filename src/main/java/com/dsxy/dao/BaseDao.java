package com.dsxy.dao;

import com.dsxy.model.Student;
import com.dsxy.model.Teacher;
import com.dsxy.util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO基类
 */
public class BaseDao {
    /**
     * 通用的增删改方法
     * @param sql 执行的调用语句
     * @param params sql赋值参数
     * @return 受影响行数
     */
    public int executeUpdate(String sql,Object... params) throws SQLException {
        //获取数据库连接
        Connection conn = JDBCUtil.getConnection();
        //预编译sql语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //处理占位符
        if(params != null&&params.length>0) {
            for (int i = 0; i < params.length; i++) {
                //占位符从1开始，数组从0开始
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        //执行方法--row受影响的行数
        int row=preparedStatement.executeUpdate();
        //释放资源
        preparedStatement.close();
        JDBCUtil.release();
        //返回结果
        return row;
    }

    /**
     * 通用的查询方法
     * @param clazz 查询的对象
     * @param sql 执行的调用语句
     * @param params sql赋值参数
     * @return 链表
     */
    public <T> List<T> executeQuery(Class<T> clazz,String sql, Object...params) throws Exception {
        //获取数据库连接
        Connection conn = JDBCUtil.getConnection();
        //预编译sql语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //处理占位符
        if(params != null&&params.length>0) {
            for (int i = 0; i < params.length; i++) {
                //占位符从1开始，数组从0开始
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        //执行方法--row受影响的行数
        ResultSet resultSet=preparedStatement.executeQuery();
        //获取结果集中的数据对象
        //列的数量和名称
        ResultSetMetaData metaData=resultSet.getMetaData();
        //获取列数
        int columnCount = metaData.getColumnCount();
        //存放封装结果的链表
        List<T> list=new ArrayList<T>();
        //处理结果
        while(resultSet.next()){
            //循环一次创建一次对象
            T t=clazz.newInstance();
            //循环列数拿出数据
            for(int i=1;i<=columnCount;i++){
                //通过下标获取每列的值
                Object value = resultSet.getObject(i);
                //获取拿到列的名字--对象的属性名
                String fieldName = metaData.getColumnLabel(i);
                //通过类对象和fieldName获取要的对象的属性
                Field field = clazz.getDeclaredField(fieldName);
                //突破封装的private
                field.setAccessible(true);
                field.set(t,value);
            }
            //添加到链表
            list.add(t);
        }
        //释放资源
        resultSet.close();
        preparedStatement.close();
        JDBCUtil.release();
        //返回链表
        return list;
    }

    /**
     * 通用查询，在上面查询结果中获取第一个结果，简化单行多列的情况
     */
    public <T> T executeQueryBean(Class<T> clazz,String sql, Object...params)throws Exception{
        //调用上面的查询方法
        List<T> list = this.executeQuery(clazz, sql, params);
        if(list==null|| list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

}
