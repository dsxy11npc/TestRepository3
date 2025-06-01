package com.dsxy.controller;

import com.dsxy.dao.StudentDao;
import com.dsxy.dao.TeacherDao;
import com.dsxy.dao.impl.StudentTable;
import com.dsxy.dao.impl.TeacherTable;
import com.dsxy.model.Student;
import com.dsxy.model.Teacher;
import com.dsxy.util.PasswordUtil;
import com.dsxy.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dsxy.util.Result.ERROR;

/**
 * 登录权限控制器
 */
@RestController
@RequestMapping("/api/logins")
public class LoginController {

    //学生登录
    @GetMapping(value="/student",headers="content-type=application/json")
    public Result<Student> loginStudent(String No,String password){
        StudentDao studentDao=new StudentTable();
        //获取登录对象
        Student student=studentDao.selectByStudentNo(No);
        //测试密码
        if(student!=null&&PasswordUtil.checkPassword(password,student.getPassword())){
            return Result.success(student);
        }else{
            return Result.error(ERROR,"登录失败");
        }
    }

    //教师登录
    @GetMapping(value="/teacher",headers="content-type=application/json")
    public Result<Teacher> loginTeacher(String No, String password){
        TeacherDao teacherDao=new TeacherTable();
        //获取登录对象
        Teacher teacher=teacherDao.selectByTeachId(No);
        //测试密码
        if(teacher!=null&&PasswordUtil.checkPassword(password,teacher.getPassword())){
            return Result.success(teacher);
        }else{
            return Result.error(ERROR,"登录失败");
        }
    }
}
