package de.adorsys.basepopulator.controller;

import de.adorsys.basepopulator.service.FileService;
import de.adorsys.basepopulator.service.impl.FileServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class UploadController {
    private static final Logger logger = Logger.getLogger(UploadController.class.getName());

    private final FileService fileService;

    public UploadController(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public void upload(@RequestParam MultipartFile file) {

        try {
            fileService.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
