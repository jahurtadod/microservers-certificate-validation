package com.example.certificate.service;

import com.example.certificate.entity.Certificate;
import com.example.certificate.model.Student;
import com.example.certificate.model.Course;

import java.util.List;

public interface CertificateService {

    Certificate getCertificate(Long id);
    public List<Certificate> findCertificateAll();
    public Certificate  createCertificate (Certificate certificate, Student student, Course course);
    public Certificate updateCertificate (Certificate certificate, Student student, Course course);
    public Certificate deleteCertificate (Certificate certificate);

}
