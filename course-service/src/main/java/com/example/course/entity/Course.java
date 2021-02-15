package com.example.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_courses")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "nameinstitute")
    private String nameInstitute;
    @Column(name = "numhours")
    private int numHours;
    @Column(name = "editioncourse")
    private String editionCourse;
    private String instructor;
    private double cost;
    private Date date;
}
