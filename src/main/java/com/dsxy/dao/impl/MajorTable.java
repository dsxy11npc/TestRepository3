package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.CourseDao;
import com.dsxy.dao.MajorDao;
import com.dsxy.model.Course;
import com.dsxy.model.Major;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * JDBC操作专业
 */
public class MajorTable extends BaseDao implements MajorDao {
    //查询全部专业
    @Override
    public List<Major> selectAll() {
        //定义sql
        String sql="select id,major_no majorNo,major_name majorName,department_id departmentId," +
                "create_time createTime,update_time updateTime from t_major";
        try {
            return executeQuery(Major.class,sql,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //查询单个专业
    @Override
    public Major selectByMajorId(String id) {
        String sql ="select id,major_no majorNo,major_name majorName,department_id departmentId," +
                "create_time createTime,update_time updateTime from t_major where id=?";
        try {
            return executeQueryBean(Major.class,sql,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //添加专业
    @Override
    public int insert(Major major) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String  sql="insert into t_major(id,major_no,major_name,department_id,create_time,update_time) values(?,?,?,?,?,?)";
        try {
            return executeUpdate(sql,major.getId(),major.getMajorNo(),major.getMajorName(),major.getDepartmentId(),now,now);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改专业
    @Override
    public int update(Major major) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //定义sql
        String sql="update t_major set major_no=?,major_name=?,department_id=?,update_time=? where id=?" ;
        try {
            return executeUpdate(sql,major.getMajorNo(),major.getMajorName(),major.getDepartmentId(),now,major.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除专业
    @Override
    public int delete(String id) {
        String sql="delete from t_major where id=?";
        try {
            return executeUpdate(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
