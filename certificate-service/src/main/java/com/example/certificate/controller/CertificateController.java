package com.example.certificate.controller;

import com.example.certificate.entity.Certificate;
import com.example.certificate.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
