package com.example.certificate;

import com.example.certificate.entity.Certificate;
import com.example.certificate.repository.CertificateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class CertificateRepositoryMockTest {
    @Autowired
    private CertificateRepository certificateRepository;

    @Test
    public void  wheFindById_thenReturnCertificate() {
        Certificate certificate = Certificate.builder()
                .course(1L)
                .student(1L)
                .status("APROBADO").build();
        certificateRepository.save(certificate);

        Optional<Certificate> founds = certificateRepository.findById(1L);

        assertFalse(founds.isEmpty());
    }
}
