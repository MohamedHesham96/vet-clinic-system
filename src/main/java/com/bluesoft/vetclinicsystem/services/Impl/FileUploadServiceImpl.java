package com.bluesoft.vetclinicsystem.services.Impl;

import com.bluesoft.vetclinicsystem.services.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    public boolean validateImageFile(MultipartFile file) {
        return file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") || file.getContentType().equals("image/jpg");
    }

    public String writeFile(MultipartFile uploadedFile, String uploadFolder, String folderDirectory, String fileName) throws IOException {
        byte[] fileBytes = uploadedFile.getBytes();
        File uploadDirectory = new File(uploadFolder + "/" + folderDirectory);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }
        try (BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(uploadDirectory + "/" + fileName))) {
            stream.write(fileBytes);
        }
        return uploadDirectory + "/" + fileName;
    }
}
