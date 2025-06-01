package com.dsxy.dao.impl;

import com.dsxy.dao.BaseDao;
import com.dsxy.dao.CourseDao;
import com.dsxy.model.Course;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * JDBC操作课程
 */
public class CourseTable extends BaseDao implements CourseDao {

    //查询全部课程
    @Override
    public List<Course> selectAll() {
        //定义sql
        String sql="select course_no courseNo,course_name courseName,teacher_id teacherId,major_id majorId,grade," +
                "course_type courseType,credit,is_public isPublic,status,create_time createTime,update_time updateTime from t_course";
        try {
            return executeQuery(Course.class,sql,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //查询单个课程
    @Override
    public Course selectByCourseNo(String courseNo) {
        String sql ="select course_no courseNo,course_name courseName,teacher_id teacherId,major_id majorId,grade," +
                "course_type courseType,credit,is_public isPublic,status,create_time createTime,update_time updateTime from t_course where course_no=?";
        try {
            return executeQueryBean(Course.class,sql,courseNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //增加新课程
    @Override
    public int insert(Course course) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String sql="insert into t_course(course_no,course_name,teacher_id,major_id,grade,course_type,credit,is_public,status,create_time,update_time)"+
                " values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            return executeUpdate(sql,course.getCourseNo(),course.getCourseName(),course.getTeacherId(),course.getMajorId(),course.getGrade(),
                    course.getCourseType(),course.getCredit(), course.getIsPublic(),course.getStatus(),now,now);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //更新课程信息
    @Override
    public int update(Course course) {
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //定义sql
        String sql="update t_course set course_name=?,teacher_id=?,major_id=?,grade=?,course_type=?,credit=?,is_public=?,status=?,update_time=? where course_no=?" ;
        try {
            return executeUpdate(sql,course.getCourseName(),course.getTeacherId(),course.getMajorId(),course.getGrade(),
                    course.getCourseType(),course.getCredit(), course.getIsPublic(),course.getStatus(),now,course.getCourseNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //删除课程
    @Override
    public int delete(String courseNo) {
        String sql="delete from t_course where course_no=?";
        try {
            return executeUpdate(sql,courseNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //更新课程状态
    @Override
    public int updateStatus(String courseNo,Integer status) {
        //定义sql
        String sql="update t_course set status=? where course_no=?" ;
        try {
            return executeUpdate(sql,status,courseNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
