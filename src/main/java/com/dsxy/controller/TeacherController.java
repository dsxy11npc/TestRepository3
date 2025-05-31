package com.dsxy.controller;

import com.dsxy.dao.CourseDao;
import com.dsxy.dao.impl.CourseTable;
import com.dsxy.model.Course;
import com.dsxy.model.Teacher;
import com.dsxy.util.Result;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.dsxy.util.Result.ERROR;
import static com.dsxy.util.Result.PARAM_ERROR;

/**
 * 教师权限控制器
 */
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    //添加课程
    @PutMapping(value="/course",headers="content-type=application/json")
    public Result<Course> addCourse(@RequestBody Course course) {
        CourseDao courseDao=new CourseTable();
        //受影响行数判断是否添加成功
        if(courseDao.insert(course)>0){
            return Result.success(course);
        }
        else{
            return Result.error(ERROR,"添加失败");
        }
    }
}
