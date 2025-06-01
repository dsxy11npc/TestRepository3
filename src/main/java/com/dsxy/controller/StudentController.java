package com.dsxy.controller;


import com.dsxy.dao.CourseDao;
import com.dsxy.dao.StudentDao;
import com.dsxy.dao.impl.CourseTable;
import com.dsxy.dao.impl.StudentTable;
import com.dsxy.model.Course;
import com.dsxy.model.Student;
import com.dsxy.util.Result;
import org.springframework.web.bind.annotation.*;

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
        //受影响行数判断是否添加成功
        if(studentDao.update(student)>0){
            return Result.success(student);
        }
        else{
            return Result.error(ERROR,"修改失败");
        }
    }

}
