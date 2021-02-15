package com.example.certificate.model;

import lombok.Data;

import java.util.Date;

@Data
public class Course {
    private Long id;
    private String name;
    private String nameInstitute;
    private int numHours;
    private String editionCourse;
    private String instructor;
    private double cost;
    private Date date;
}
