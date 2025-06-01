package com.dsxy.controller;


import com.dsxy.dao.CourseDao;
import com.dsxy.dao.StudentDao;
import com.dsxy.dao.impl.CourseTable;
import com.dsxy.dao.impl.StudentTable;
import com.dsxy.model.Course;
import com.dsxy.model.Student;
import com.dsxy.util.PasswordUtil;
import com.dsxy.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dsxy.util.Result.ERROR;

/**
 * 学生权限控制器
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    //查询学生信息（单个学生）
    @GetMapping(value="/get/{studentNo}",headers="content-type=application/json")
    public Result<Student> getStudent(@PathVariable String studentNo) {
        StudentDao studentDao = new StudentTable();
        Student student=studentDao.selectByStudentNo(studentNo);
        if(student!=null){
            return Result.success(student);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

    //修改个人信息
    @PostMapping(value="/postStudent",headers="content-type=application/json")
    public Result<Student> modifyStudent(@RequestBody Student student){
        StudentDao studentDao = new StudentTable();
        //加密密码
        String hashPassword= PasswordUtil.hashPassword(student.getPassword());
        student.setPassword(hashPassword);
        //受影响行数判断是否添加成功
        if(studentDao.update(student)>0){
            return Result.success(student);
        }
        else{
            return Result.error(ERROR,"修改失败");
        }
    }

    //获取选课
    @GetMapping(value="/getCourse/{studentNo}",headers="content-type=application/json")
    public Result<List<Course>> getCourse(@PathVariable String studentNo){
        StudentDao studentDao = new StudentTable();
        List<Course>courses=studentDao.selectCourseByStudentNo(studentNo);
        if(courses!=null){
            return Result.success(courses);
        }else{
            return Result.error(ERROR,"获取失败");
        }
    }

    //选课
    @GetMapping(value="/choiceCourse/{studentNo}",headers="content-type=application/json")
    public Result<Student> choiceCourse(@PathVariable String studentNo,String choice){
        StudentDao studentDao = new StudentTable();
        if(studentDao.choiceCourse(studentNo,choice)>0){
            return Result.success();
        }else{
            return Result.error(ERROR,"选择失败");
        }
    }
}
