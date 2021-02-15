package com.example.course;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import com.example.course.service.CourseService;
import com.example.course.service.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceMockTest {

    @Mock
    private CourseRepository courseRepository;

    private CourseService courseService;

    @BeforeEach
    public void setup () {
        courseService = new CourseServiceImpl(courseRepository);
        Course course = Course.builder()
                .name("Design UX")
                .nameInstitute("UTPL")
                .numHours(60)
                .editionCourse("4ta Edition")
                .instructor("Jorge Hurtado")
                .cost(100.99)
                .date(new Date()).build();

        Mockito.when(courseRepository.findById(1L))
                .thenReturn(Optional.of(course));
    }

    @Test
    public void whenValidGetID_thenReturnStudent () {
        Course found = courseService.getCourse(1L);
        assertThat(found.getName()).isEqualTo("Design UX");
    }
}
