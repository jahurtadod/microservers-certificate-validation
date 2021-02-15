package com.example.certificate.client;

import com.example.certificate.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "course-service")
@RequestMapping(value = "/courses")
public interface CourseClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Course> getCourse(@PathVariable("id") Long id);


}
