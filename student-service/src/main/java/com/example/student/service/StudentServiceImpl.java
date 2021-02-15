package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student createStudent(Student student) {

        student.setName("Luis Ortiz");
        student.setEmail("leor@gmail.com");
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student studentUpdate = getStudent(student.getId());
        if (studentUpdate == null) {
            return null;
        }
        studentUpdate.setName(student.getName());
        studentUpdate.setEmail(student.getEmail());

        return studentRepository.save(studentUpdate);
    }

}
