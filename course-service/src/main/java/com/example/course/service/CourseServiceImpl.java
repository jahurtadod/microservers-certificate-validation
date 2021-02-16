package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{


    private final CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> findCourseAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(@NonNull Course course) {

        course.setName(course.getName());
        course.setEditionCourse(course.getEditionCourse());
        course.setInstructor(course.getInstructor());
        course.setNameInstitute(course.getNameInstitute());
        course.setNumHours(course.getNumHours());
        course.setCost(course.getCost());
        course.setDate(new Date());
        return courseRepository.save(course);
    }
    @Override
    public Course updateCourse(Course course) {
        Course courseUpdate = getCourse(course.getId());
        if (courseUpdate == null){
            return null;
        }
        courseUpdate.setName(course.getName());
        courseUpdate.setNameInstitute(course.getNameInstitute());
        courseUpdate.setEditionCourse(course.getEditionCourse());
        courseUpdate.setDate(course.getDate());
        courseUpdate.setNumHours(course.getNumHours());
        courseUpdate.setCost(course.getCost());
        courseUpdate.setInstructor(course.getInstructor());

        return courseRepository.save(courseUpdate);
    }
    @Override
    public Course deleteCourse(Course course) {
        Course courseDeleted = getCourse(course.getId());
        if (courseDeleted == null){
            return null;
        }
        return courseRepository.save(course);
    }

}
