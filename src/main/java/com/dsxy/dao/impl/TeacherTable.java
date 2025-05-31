package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.TeacherDao;
import com.dsxy.model.Course;
import com.dsxy.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public class TeacherTable extends BaseDao implements TeacherDao {

    //查询全部
    @Override
    public List<Teacher> selectAll() {
        String sql ="select teacher_no teacherNo,password,department_id departmentId,name,phone from t_teacher ";
        try {
            return executeQuery(Teacher.class,sql,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher selectByTeachId(String TeachNo) {
        String sql ="select teacher_no teacherNo,password,department_id departmentId,name,phone from t_teacher where teacher_no=?";
        try {
            return executeQueryBean(Teacher.class,sql,TeachNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(Teacher teacher) {
        String  sql="insert into t_teacher(teacher_no,password,department_id,name,phone) values(?,?,?,?,?)";
        try {
            return executeUpdate(sql,teacher.getTeacherNo(),teacher.getPassword(),teacher.getDepartmentId(),teacher.getName(),teacher.getPhone());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Teacher teacher) {
        String  sql="update t_teacher set ";
        try {
            return executeUpdate(sql,teacher.getTeacherNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(String TeachNo) {
        String sql="delete from t_teacher where teacher_no=?";
        try {
            return executeUpdate(sql,TeachNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
