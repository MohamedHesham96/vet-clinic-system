package com.bluesoft.vetclinicsystem.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    String writeFile(MultipartFile uploadedFile, String uploadFolder, String folderDirectory, String fileName) throws IOException;

    boolean validateImageFile(MultipartFile file);
}