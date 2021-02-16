package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudent(id);
        if (student == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

    //-------------------------TODOS LOS ESTUDIANTES-------------------------
    @GetMapping
    public ResponseEntity<List<Student>> findCourseAll (){
        List<Student> students = studentService.findStudentAll();

        if (students.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(students);
    }
    //-------------------------POR NOMBRE-------------------------
    @GetMapping(value = "/search")
    public ResponseEntity<Student> findStudentByName(@RequestParam(name = "Jorge Hurtado", required = false) String name){
        Student student = new Student();

        if (name != null){
            student = studentService.findStudentByName(name);
            if (null == student){
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(student);
    }
    //-------------------------CREAR-------------------------
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentCreate = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreate);
    }

    //-------------------------MODIFICAR-------------------------
    @PostMapping(value = "/{id}")
    public ResponseEntity<Student> updateCourse(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        Student studentUpdate = studentService.updateStudent(student);
        if (studentUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
