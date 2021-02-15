package com.example.certificate.service;

import com.example.certificate.client.CourseClient;
import com.example.certificate.client.StudentClient;
import com.example.certificate.entity.Certificate;
import com.example.certificate.model.Course;
import com.example.certificate.model.Student;
import com.example.certificate.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    CourseClient courseClient;

    @Autowired
    StudentClient studentClient;

    @Override
    public Certificate getCertificate(Long id) {
        Certificate certificate = certificateRepository.findById(id).orElse(null);
        if (certificate != null) {
            Course course = courseClient.getCourse(certificate.getCourseId()).getBody();
            certificate.setCourse(course);
            Student student = studentClient.getStudent(certificate.getStudentId()).getBody();
            certificate.setStudent(student);
        }
        return certificate;
    }
}
