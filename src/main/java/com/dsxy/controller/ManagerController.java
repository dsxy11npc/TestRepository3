package com.dsxy.controller;

import com.dsxy.dao.MajorDao;
import com.dsxy.dao.StudentDao;
import com.dsxy.dao.TeacherDao;
import com.dsxy.dao.impl.MajorTable;
import com.dsxy.dao.impl.StudentTable;
import com.dsxy.dao.impl.TeacherTable;
import com.dsxy.model.Major;
import com.dsxy.model.Student;
import com.dsxy.model.Teacher;
import com.dsxy.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dsxy.util.Result.ERROR;

/**
 * 管理权限控制器
 */
@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    //添加教师
    @PutMapping(value="/putTeacher",headers="content-type=application/json")
    public Result<Teacher> addTeacher(@RequestBody Teacher teacher) {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        if(teacherDao.insert(teacher)>0){
            return Result.success(teacher);
        }else{
            return Result.error(ERROR,"添加失败");
        }
    }

    //批量添加教师
    @PutMapping(value="/putMoreTeacher",headers="content-type=application/json")
    public Result<List<Teacher>> addTeacherMore(@RequestBody List<Teacher> teachers) {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        if(teacherDao.insertMore(teachers)>0){
            return Result.success(teachers);
        }else{
            return Result.error(ERROR,"添加失败");
        }
    }

    //修改教师
    @PostMapping(value="/postTeacher",headers="content-type=application/json")
    public Result<Teacher> modifyTeacher(@RequestBody Teacher teacher) {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        if(teacherDao.update(teacher)>0){
            return Result.success(teacher);
        }else{
            return Result.error(ERROR,"修改失败");
        }

    }

    //删除教师
    @DeleteMapping(value="/deleteTeacher",headers="content-type=application/json")
    public Result<Teacher> deleteTeacher(String teacherNo) {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        if(teacherDao.delete(teacherNo)>0){
            return Result.success();
        }else{
            return Result.error(ERROR,"删除失败");
        }
    }

    //查询教师
    @GetMapping(value="/getTeacher",headers="content-type=application/json")
    public Result<Teacher> getTeacher(String teacherNo) {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        Teacher teacher=teacherDao.selectByTeachId(teacherNo);
        if(teacher!=null){
            return Result.success(teacher);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }
    //查询全部教师
    @GetMapping(value="/getAllTeacher",headers="content-type=application/json")
    public Result<List<Teacher>> getTeacherAll() {
        TeacherDao teacherDao=new TeacherTable();
        //受影响行数判断是否添加成功
        List<Teacher> teachers=teacherDao.selectAll();
        if(teachers!=null){
            return Result.success(teachers);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

    //添加学生
    @PutMapping(value="/putStudent",headers="content-type=application/json")
    public Result<Student> addStudent(@RequestBody Student student) {
        StudentDao studentDao=new StudentTable();
        //受影响行数判断是否添加成功
        if(studentDao.insert(student)>0){
            return Result.success(student);
        }else{
            return Result.error(ERROR,"添加失败");
        }
    }

    //批量添加学生
    @PutMapping(value="/putMoreStudent",headers="content-type=application/json")
    public Result<List<Student>> addStudentMore(@RequestBody List<Student> students) {
        StudentDao studentDao=new StudentTable();
        //受影响行数判断是否添加成功
        if(studentDao.insertMore(students)>0){
            return Result.success(students);
        }else{
            return Result.error(ERROR,"添加失败");
        }
    }

    //修改学生
    @PostMapping(value="/postStudent",headers="content-type=application/json")
    public Result<Student> modifyStudent(@RequestBody Student student) {
        StudentDao studentDao=new StudentTable();
        //受影响行数判断是否添加成功
        if(studentDao.update(student)>0){
            return Result.success(student);
        }else{
            return Result.error(ERROR,"修改失败");
        }
    }

    //删除学生
    @DeleteMapping(value="/deleteStudent",headers="content-type=application/json")
    public Result<Student> deleteStudent(String studentNo) {
        StudentDao studentDao=new StudentTable();
        //受影响行数判断是否添加成功
        if(studentDao.delete(studentNo)>0){
            return Result.success();
        }else{
            return Result.error(ERROR,"删除失败");
        }
    }

    //查询学生
    @GetMapping(value="/getStudent",headers="content-type=application/json")
    public Result<Student> getStudent(String studentNo) {
        StudentDao studentDao=new StudentTable();
        //对象是否为空判断是否操作成功
        Student student=studentDao.selectByStudentNo(studentNo);
        if(student!=null){
            return Result.success(student);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }
    //查询全部教师
    @GetMapping(value="/getAllStudent",headers="content-type=application/json")
    public Result<List<Student>> getStudentAll() {
        StudentDao studentDao=new StudentTable();
       //对象是否为空判断是否操作成功
        List<Student> students=studentDao.selectAll();
        if(students!=null){
            return Result.success(students);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

    //添加专业
    @PutMapping(value="/putMajor",headers="content-type=application/json")
    public Result<Major> addMajor(@RequestBody Major major) {
        MajorDao majorDao=new MajorTable();
        //受影响行数判断是否添加成功
        if(majorDao.insert(major)>0){
            return Result.success(major);
        }else{
            return Result.error(ERROR,"添加失败");
        }
    }

    //修改专业
    @PostMapping(value="/postMajor",headers="content-type=application/json")
    public Result<Major> modifyMajor(@RequestBody Major major) {
        MajorDao majorDao=new MajorTable();
        //受影响行数判断是否添加成功
        if(majorDao.update(major)>0){
            return Result.success(major);
        }else{
            return Result.error(ERROR,"修改失败");
        }
    }

    //删除专业
    @DeleteMapping(value="/deleteMajor",headers="content-type=application/json")
    public Result<Major> deleteMajor(String id) {
        MajorDao majorDao=new MajorTable();
        //受影响行数判断是否添加成功
        if(majorDao.delete(id)>0){
            return Result.success();
        }else{
            return Result.error(ERROR,"删除失败");
        }
    }

    //查询全部专业
    @GetMapping(value="/getAllMajor",headers="content-type=application/json")
    public Result<List<Major>> getMajorAll() {
        MajorDao majorDao=new MajorTable();
        //对象是否为空判断是否操作成功
        List<Major> majors=majorDao.selectAll();
        if(majors!=null){
            return Result.success(majors);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

    //查询专业
    @GetMapping(value="/getMajor",headers="content-type=application/json")
    public Result<Major> getMajor(String id) {
        MajorDao majorDao=new MajorTable();
        //对象是否为空判断是否操作成功
        Major major=majorDao.selectByMajorId(id);
        if(major!=null){
            return Result.success(major);
        }else{
            return Result.error(ERROR,"查询失败");
        }
    }

}
