package com.example.course;


import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class CourseRepositoryMockTest {
    @Autowired
    private CourseRepository courseRepository;

    public void whenFindByName_thenReturnListCourses(){
        Course course01 = Course.builder()
                .name("Design UI")
                .nameInstitute("UTPL")
                .numHours(60)
                .editionCourse("4ta Edition")
                .instructor("Jorge Hurtado")
                .cost(100.99)
                .date(new Date()).build();
        courseRepository.save(course01);

        //List<Course> founds = courseRepository.findCourses(course01.getName());

        //Assertions.assertAll(founds.size());

    }

}
