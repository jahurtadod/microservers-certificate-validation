package com.example.course;


import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class CourseRepositoryMockTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void whenFindByName_thenReturnListCourses(){
        Course course01 = Course.builder()
                .name("Design UX")
                .nameInstitute("UTPL")
                .numHours(60)
                .editionCourse("4ta Edition")
                .instructor("Jorge Hurtado")
                .cost(100.99)
                .date(new Date()).build();
        courseRepository.save(course01);

        Optional<Course> founds = courseRepository.findById(2L);

        assertFalse(founds.isEmpty());

    }

}
