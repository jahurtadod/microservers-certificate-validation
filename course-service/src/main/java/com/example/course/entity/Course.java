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
    private String name;
    private String nameInstitute;
    private int numHours;
    private String editionCourse;
    private String instructor;
    private double cost;
    //@Column(name= "date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
}
