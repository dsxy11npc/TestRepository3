package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.DepartmentDao;
import com.dsxy.dao.MajorDao;
import com.dsxy.model.Department;
import com.dsxy.model.Major;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DepartmentTable extends BaseDao implements DepartmentDao {
    //查询全部院系
    @Override
    public List<Department> selectAll() {
        //定义sql
        String sql="select id,dept_no departmentNo,dept_name departmentName," +
                "create_time createTime,update_time updateTime from t_department";
        try {
            return executeQuery(Department.class,sql,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //查询单个院系
    @Override
    public Department selectByDepartmentId(String Id) {
        String sql ="select id,dept_no departmentNo,dept_name departmentName," +
                "create_time createTime,update_time updateTime from t_department where id=?";
        try {
            return executeQueryBean(Department.class,sql,Id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //添加院系
    @Override
    public int insert(Department department) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String sql="insert into t_department(id,dept_no,dept_name,create_time,update_time)"+
                " values(?,?,?,?,?)";
        try {
            return executeUpdate(sql,department.getId(),department.getDepartmentNo(),department.getDepartmentName(),now,now);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改院系
    @Override
    public int update(Department department) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //定义sql
        String sql="update t_department set dept_no=?,dept_name=?,update_time=? where id=?" ;
        try {
            return executeUpdate(sql,department.getDepartmentNo(),department.getDepartmentName(),now,department.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除院系
    @Override
    public int delete(String Id) {
        String sql="delete from t_department where id=?";
        try {
            return executeUpdate(sql,Id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
