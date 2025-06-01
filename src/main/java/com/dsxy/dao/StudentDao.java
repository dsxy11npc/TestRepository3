package com.dsxy.dao;

import com.dsxy.model.Course;
import com.dsxy.model.Student;
import com.dsxy.model.Teacher;

import java.util.List;

public interface StudentDao {
    /**
     * 查询所有操作
     * @return 表中所有数据
     */
    List<Student> selectAll();

    /**
     * 数据库根据ID查询单个数据
     * @param studentNo 主键列
     * @return 单个学生
     */
    Student selectByStudentNo(String studentNo);

    /**
     * 新增一条学生数据
     * @param student 学生对象
     * @return 受影响的行数
     */
    int insert(Student student);

    /**
     * 修改学生数据
     * @param student 学生对象
     * @return 受影响行数
     */
    int update(Student student);

    /**
     * 删除学生数据
     * @param studentNo 主键列
     * @return 受影响行数
     */
    int delete(String studentNo);

    /**
     * 批量添加学生
     * @param students 学生链表
     * @return 受影响行数
     */
    int insertMore(List<Student> students);

    /**
     * 选择的课
     * @param studentNo 学生学号
     * @return 所选课程
     */
    List<Course> selectCourseByStudentNo(String studentNo);

    /**
     * 选课
     * @param studentNo 学生学号
     * @return 学生对象
     */
    int choiceCourse(String studentNo,String choice);
}
