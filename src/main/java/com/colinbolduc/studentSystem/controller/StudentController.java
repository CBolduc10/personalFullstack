package com.colinbolduc.studentSystem.controller;

import com.colinbolduc.studentSystem.model.Student;
import com.colinbolduc.studentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return("New Student Has Ben Added.");
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if (id != null){
            try{
                studentService.deleteStudent(id);
                return("Student ID=" + id + " Has Been Removed.");
            } catch(EmptyResultDataAccessException x) {
                return("Student ID Does Not Exist.");
            }

        } else {
            return("NULL id given. Delete Failed.");
        }

    }

}
