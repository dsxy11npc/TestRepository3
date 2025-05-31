package com.dsxy.controller;

import com.dsxy.dao.TeacherDao;

import com.dsxy.dao.impl.TeacherTable;
import com.dsxy.model.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器
 */
@RestController
@RequestMapping("/api/auth")
public class Login {

    @GetMapping("/test")
    public Teacher getTeacher(){
        TeacherDao teacherDao=new TeacherTable();
        return teacherDao.selectByTeachId("23001001");
    }



}

