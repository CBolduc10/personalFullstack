package com.colinbolduc.studentSystem.service;

import com.colinbolduc.studentSystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public void deleteStudent(Integer id);
}
