package com.example.student.service;
import java.util.List;

import com.example.student.entity.Student;

public interface StudentService {

    public Student getStudent(Long id);
    public List<Student> findStudentAll();
    public Student findStudentByName(String Name);

    public Student createStudent (Student student);
    public Student updateStudent (Student student);

}
