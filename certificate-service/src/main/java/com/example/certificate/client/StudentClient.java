package com.example.certificate.client;

import com.example.certificate.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "student-service")
@RequestMapping(value = "/students")
public interface StudentClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Student> getStudent(@PathVariable("id") Long id);

}
