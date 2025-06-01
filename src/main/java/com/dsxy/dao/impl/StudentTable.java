package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.StudentDao;
import com.dsxy.dao.TeacherDao;
import com.dsxy.model.Course;
import com.dsxy.model.Student;
import com.dsxy.model.Teacher;
import com.dsxy.util.PasswordUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * JDBC操作学生
 */
public class StudentTable extends BaseDao implements StudentDao {
    //查询全部学生
    @Override
    public List<Student> selectAll() {
        String sql ="select student_no studentNo,password,major_id majorId,department_id departmentId,name,phone,choice from t_student";
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
        String sql="select student_no studentNo,password,major_id majorId,department_id departmentId,name,phone,choice from t_student where student_no=?";
        try {
            return executeQueryBean(Student.class,sql,studentNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //添加个人信息
    @Override
    public int insert(Student student) {
        String  sql="insert into t_student(student_no,password,major_id,department_id,name,phone,choice) values(?,?,?,?,?,?,?)";
        try {
            return executeUpdate(sql,student.getStudentNo(),student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone(),student.getChoice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //修改个人信息
    @Override
    public int update(Student student) {
        String sql="update t_student set password=?,major_id=?,department_id=?,name=?,phone=?,choice=? where student_no=?";
        try {
            return executeUpdate(sql,student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone(),student.getChoice(),student.getStudentNo());
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
            String sql="insert into t_student(student_no,password,major_id,department_id,name,phone,choice) values(?,?,?,?,?,?,?)";
            try {
                allRow+=executeUpdate(sql,student.getStudentNo(),student.getPassword(),student.getMajorId(),student.getDepartmentId(),student.getName(),student.getPhone(),student.getChoice());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return allRow;
    }
    //选择的课
    @Override
    public List<Course> selectCourseByStudentNo(String studentNo){
        List<Course> courses=new ArrayList<>();
        String sql="select choice from t_student where student_no=?";
        try {
            Student student=executeQueryBean(Student.class,sql,studentNo);
            //逗号分隔选课编号
            String[] choices=student.getChoice().split(",");
            //调用课程查询的方法找到所有课程
            for(String choice:choices) {
                String courseSql = "select course_no courseNo,course_name courseName,teacher_id teacherId,major_id majorId,grade," +
                        "course_type courseType,credit,is_public isPublic,status,create_time createTime,update_time updateTime from t_course where course_no=?";
                courses.add(executeQueryBean(Course.class, courseSql, choice));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
    //选课操作
    @Override
    public int choiceCourse(String studentNo,String choice){
        String sql="update t_student set choice=? where student_no=?";
        try {
            return executeUpdate(sql,choice,studentNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
