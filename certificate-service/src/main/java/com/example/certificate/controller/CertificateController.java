package com.example.certificate.controller;

import com.example.certificate.entity.Certificate;
import com.example.certificate.model.Course;
import com.example.certificate.model.Student;
import com.example.certificate.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Certificate> getCertificate(@PathVariable("id") Long id){
        Certificate certificate = certificateService.getCertificate(id);
        if (certificate == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(certificate);
    }
    //-------------------------TODOS LOS CURSOS-------------------------
    @GetMapping
    public ResponseEntity<List<Certificate>> findCourseAll (){
        List<Certificate> certificates = certificateService.findCertificateAll();

        if (certificates.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(certificates);
    }

    //-------------------------CREAR-------------------------
    @PostMapping
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate, Student student, Course course){
        Certificate certificateCreate = certificateService.createCertificate(certificate, student, course);
        return ResponseEntity.status(HttpStatus.CREATED).body(certificateCreate);
    }

    //-------------------------MODIFICAR-------------------------
    @PostMapping(value = "/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable("id") Long id, @RequestBody Certificate certificate, Student student, Course course){
        certificate.setId(id);
        Certificate certificateUpdate = certificateService.updateCertificate(certificate, student, course);
        if (certificateUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(certificate);
    }

}
