package de.adorsys.basepopulator.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    void parse(MultipartFile file) throws IOException;
}
