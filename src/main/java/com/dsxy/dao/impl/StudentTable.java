package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.StudentDao;
import com.dsxy.dao.TeacherDao;
import com.dsxy.model.Course;
import com.dsxy.model.Student;
import com.dsxy.model.Teacher;

import java.sql.SQLException;
import java.util.List;
/**
 * JDBC操作学生
 */
public class StudentTable extends BaseDao implements StudentDao {
    //查询全部学生
    @Override
    public List<Student> selectAll() {
        String sql ="select student_no studentNo,password,major_id majorId,department_id departmentId,name,phone from t_student";
        try {
            return executeQuery(Student.class,sql,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //查询个人信息
    @Override
    public Student selectByStudentNo(String studentNo) {
        //定义sql
        String sql="select student_no studentNo,password,major_id majorId,department_id departmentId,name,phone from t_student where student_no=?";
        try {
            return executeQueryBean(Student.class,sql,studentNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //添加个人信息
    @Override
    public int insert(Student student) {
        String  sql="insert into t_student(student_no,password,major_id,department_id,name,phone) values(?,?,?,?,?,?)";
        try {
            return executeUpdate(sql,student.getStudentNo(),student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改个人信息
    @Override
    public int update(Student student) {
        String sql="update t_student set password=?,major_id=?,department_id=?,name=?,phone=? where student_no=?";
        try {
            return executeUpdate(sql,student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone(),student.getStudentNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除学生
    @Override
    public int delete(String studentNo) {
        String sql="delete from t_student where student_no=?";
        try {
            return executeUpdate(sql,studentNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //批量添加学生
    @Override
    public int insertMore(List<Student> students) {
        int allRow=0;
        for(Student student:students){
            String sql="insert into t_student(student_no,password,major_id,department_id,name,phone) values(?,?,?,?,?,?)";
            try {
                allRow+=executeUpdate(sql,student.getStudentNo(),student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return allRow;
    }
}
