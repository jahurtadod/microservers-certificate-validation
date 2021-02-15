package com.example.certificate.service;

import com.example.certificate.entity.Certificate;
import com.example.certificate.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private final CertificateRepository certificateRepository;


    @Override
    public Certificate getCertificate(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }
}
