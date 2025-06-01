package com.dsxy.dao;

import com.dsxy.model.Major;
import com.dsxy.model.Teacher;

import java.util.List;

public interface MajorDao {
    /**
     * 查询所有操作
     * @return 表中所有数据
     */
    List<Major> selectAll();

    /**
     * 数据库根据ID查询单个数据
     * @param id 主键列
     * @return 单个专业
     */
    Major selectByMajorId(String id);

    /**
     * 新增一条专业数据
     * @param major 专业对象
     * @return 受影响的行数
     */
    int insert(Major major);

    /**
     * 修改专业数据
     * @param major 专业对象
     * @return 受影响行数
     */
    int update(Major major);

    /**
     * 删除专业数据
     * @param id 主键列
     * @return 受影响行数
     */
    int delete(String id);


}
