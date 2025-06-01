package com.dsxy.controller;

import com.dsxy.dao.CourseDao;
import com.dsxy.dao.impl.CourseTable;
import com.dsxy.model.Course;
import com.dsxy.model.Teacher;
import com.dsxy.util.Result;
import jakarta.servlet.http.HttpServletRequest;
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
    @PutMapping(value="/course/put",headers="content-type=application/json")
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

    //修改课程信息
    @PostMapping(value="/course/post",headers="content-type=application/json")
    public Result<Course> modifyCourse(@RequestBody Course course) {
        CourseDao courseDao=new CourseTable();
        //受影响行数判断是否添加成功
        if(courseDao.update(course)>0){
            return Result.success(course);
        }
        else{
            return Result.error(ERROR,"修改失败");
        }
    }

    //删除课程
    @DeleteMapping(value = "/course/delete/{courseNo}",headers="content-type=application/json")
    public Result<Course> deleteCourse(@PathVariable String courseNo) {
        CourseDao courseDao=new CourseTable();
        //受影响行数判断是否添加成功
        if(courseDao.delete(courseNo)>0){
            return Result.success();
        }
        else{
            return Result.error(ERROR,"删除失败");
        }
    }

    //查询课程信息（单个课程）
    @GetMapping(value="/course/get/{courseNo}",headers="content-type=application/json")
    public Result<Course> getCourse(@PathVariable String courseNo) {
        CourseDao courseDao=new CourseTable();
        Course course=courseDao.selectByCourseNo(courseNo);
        if(course!=null){
            return Result.success(course);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

    //修改课程状态
    @PostMapping(value="/course/post/{courseNo}",headers="content-type=application/json")
    public Result<Course> modifyCourseStatus(@PathVariable String courseNo,Integer status) {
        CourseDao courseDao=new CourseTable();
        //受影响行数判断是否添加成功
        if(courseDao.updateStatus(courseNo,status)>0){
            return Result.success();
        }
        else{
            return Result.error(ERROR,"修改失败");
        }
    }
}
