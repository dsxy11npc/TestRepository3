package com.dsxy.dao;

import com.dsxy.model.Course;
import com.dsxy.model.Department;

import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有操作
     * @return 表中所有数据
     */
    List<Department> selectAll();

    /**
     * 数据库根据ID查询单个数据
     * @param Id 主键列
     * @return 单个院系
     */
    Department selectByDepartmentId(String Id);

    /**
     * 新增一条院系数据
     * @param department 院系对象
     * @return 受影响的行数
     */
    int insert(Department department);

    /**
     * 修改院系数据
     * @param department 院系对象
     * @return 受影响行数
     */
    int update(Department department);

    /**
     * 删除院系数据
     * @param Id 主键列
     * @return 受影响行数
     */
    int delete(String Id);

}
