package com.example.student;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentServiceMocTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    public void setup() {
        studentService = new StudentServiceImpl(studentRepository);
        Student student = Student.builder()
                .id(1L)
                .name("Jorge")
                .email("jorge@gmail.com").build();

        Mockito.when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));
    }

    @Test
    public void whenValidGetID_thenReturnStudent () {
        Student found = studentService.getStudent(1L);
        assertThat(found.getName()).isEqualTo("Jorge");
    }


}
