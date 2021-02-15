package com.example.student;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class StudentRepositoryMockTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenFindById_thenReturnListStudent() {
        Student student01 = Student.builder()
                .name("Ariana")
                .email("ariana_medina").build();
        studentRepository.save(student01);

        Optional<Student> founds = studentRepository.findById(3L);

        assertFalse(founds.isEmpty());
    }

}
