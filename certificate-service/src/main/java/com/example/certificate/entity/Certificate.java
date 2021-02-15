package com.example.certificate.entity;

import com.example.certificate.model.Course;
import com.example.certificate.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_certificates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "student_id")
    private Long studentId;
    private String status;

    @Transient
    private Student student;

    @Transient
    private Course course;
}
