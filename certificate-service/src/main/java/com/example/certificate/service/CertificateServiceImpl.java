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

import java.util.List;

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
    @Override
    public List<Certificate> findCertificateAll() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate createCertificate(Certificate certificate, Student student, Course course) {

        certificate.setStudent(student);
        certificate.setCourse(course);
        certificate.setCourseId(student.getId());
        certificate.setStudentId(course.getId());
        certificate.setStatus("Creado");

        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate updateCertificate (Certificate certificate, Student student, Course course) {
        Certificate certificateUpdate = getCertificate(certificate.getId());
        if (certificateUpdate == null) {
            return null;
        }
        certificateUpdate.setStudent(student);
        certificateUpdate.setCourse(course);
        certificateUpdate.setStudentId(student.getId());
        certificateUpdate.setCourseId(course.getId());
        certificateUpdate.setStatus("Actualizado");

        return certificateRepository.save(certificateUpdate);
    }
    @Override
    public Certificate deleteCertificate(Certificate certificate) {
        Certificate certificateDeleted = getCertificate(certificate.getId());
        if (certificateDeleted == null){
            return null;
        }
        certificate.setStatus("DELETED");
        return certificateRepository.save(certificate);
    }
}
