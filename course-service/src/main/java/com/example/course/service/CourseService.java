package com.example.course.service;

import com.example.course.entity.Course;
import java.util.List;

public interface CourseService {

    public Course getCourse(Long id);
    public Course getCourseByName (String name);
    public List<Course> findCourseAll();
    public Course createCourse (Course course);
    public Course updateCourse (Course course);
    public Course deleteCourse (Course course);
}
