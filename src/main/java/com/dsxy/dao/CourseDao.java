package com.dsxy.dao;

import com.dsxy.model.Course;
import com.dsxy.model.Teacher;

import java.util.List;
/**
 * 课程表的增删改查
 */
public interface CourseDao {
    /**
     * 查询所有操作
     * @return 表中所有数据
     */
    List<Course> selectAll();

    /**
     * 数据库根据ID查询单个数据
     * @param courseNo 主键列
     * @return 单个课程
     */
    Course selectByTeachId(String courseNo);

    /**
     * 新增一条课程数据
     * @param course 课程对象
     * @return 受影响的行数
     */
    int insert(Course course);

    /**
     * 修改课程数据
     * @param course 课程对象
     * @return 受影响行数
     */
    int update(Course course);

    /**
     * 删除课程数据
     * @param courseNo 主键列
     * @return 受影响行数
     */
    int delete(String courseNo);
}
