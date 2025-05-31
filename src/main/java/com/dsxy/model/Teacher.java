package com.dsxy.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 教师实体类
 */
@Getter
@Setter
public class Teacher{
    /** 教师工号 */
    private String teacherNo;
    /** 密码(加密存储) */
    private String password;
    /** 所属院系ID */
    private Long departmentId;
    /** 教师姓名 */
    private String name;
    /** 联系电话 */
    private String phone;
}
