package com.example.course.repository;

import com.example.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findCourses(Course name);
}
