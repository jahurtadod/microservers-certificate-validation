package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id) {
        Course student = courseService.getCourse(id);
        if (student == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }
    //-------------------------TODOS LOS CURSOS-------------------------
    @GetMapping
    public ResponseEntity<List<Course>> findCourseAll (){
        List<Course> courses = courseService.findCourseAll();

        if (courses.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(courses);
    }
    //-------------------------POR NOMBRE-------------------------
    @GetMapping(value = "/search")
    public ResponseEntity<Course> getCourseBy(@RequestParam(name = "name", required = false) String name){
        log.info("Buscando curso especcífico");
        Course course = new Course();

        if (name != null){
            course = courseService.getCourseByName(name);
            if (null == course){
                log.error("Curso de nombre {} no encontrado", name);
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(course);
    }
    //-------------------------CREAR-------------------------
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course courseCreate = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseCreate);
    }

    //-------------------------MODIFICAR-------------------------
    @PostMapping(value = "/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
        course.setId(id);
        Course courseUpdate = courseService.updateCourse(course);
        if (courseUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }
}
