package com.dsxy.dao;

import com.dsxy.model.Teacher;

import java.util.List;

/**
 * 教师表的增删改查
 */
public interface TeacherDao {
    /**
     * 查询所有操作
     * @return 表中所有数据
     */
    List<Teacher> selectAll();

    /**
     * 数据库根据ID查询单个数据
     * @param TeachNo 主键列
     * @return 单个教师
     */
    Teacher selectByTeachId(String TeachNo);

    /**
     * 新增一条教师数据
     * @param teacher 教师对象
     * @return 受影响的行数
     */
    int insert(Teacher teacher);

    /**
     * 修改教师数据
     * @param teacher 教师对象
     * @return 受影响行数
     */
    int update(Teacher teacher);

    /**
     * 删除教师数据
     * @param TeachNo 主键列
     * @return 受影响行数
     */
    int delete(String TeachNo);

}
