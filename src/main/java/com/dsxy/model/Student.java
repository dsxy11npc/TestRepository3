package com.dsxy.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 学生实体类
 */
@Getter
@Setter
public class Student{
    /** 学生学号 */
    private String studentNo;
    /** 密码(加密存储) */
    private String password;
    /** 学生专业 */
    private String majorId;
    /** 所属院系ID */
    private Long departmentId;
    /** 学生姓名 */
    private String name;
    /** 联系电话 */
    private String phone;
}
