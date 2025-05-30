package com.dsxy.model;

/**
 * 学生实体类
 */
public class Student extends BaseUser{
    /** 学生学号 */
    private String studentNo;
    /** 所属院系ID */
    private Long departmentId;
    /** 学生姓名 */
    private String name;
    /** 联系电话 */
    private String phone;
    /** 邮箱 */
    private String email;

    /**
     * Getter
     * Setter
     */
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
