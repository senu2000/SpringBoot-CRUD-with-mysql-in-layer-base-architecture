package com.springbootexample.ems.service.impl;

import com.springbootexample.ems.dto.EmployeeDto;
import com.springbootexample.ems.dto.FileDownloadResponse;
import com.springbootexample.ems.entity.Employee;
import com.springbootexample.ems.entity.FileData;
import com.springbootexample.ems.exeption.ResourceNotFoundExeption;
import com.springbootexample.ems.mapper.EmployeeMapper;
import com.springbootexample.ems.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH="D:/spring-boot/02. CRUD with mysql in layer base architecture/ems-backend/src/main/java/com/springbootexample/ems/uploads/";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

//    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
//        String filePath=fileData.get().getFilePath();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }

    public FileDownloadResponse downloadImageWithDetailsFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileDataOptional = fileDataRepository.findByName(fileName);
        if (fileDataOptional.isPresent()) {
            FileData fileData = fileDataOptional.get();
            String filePath = fileData.getFilePath();
            byte[] imageData = Files.readAllBytes(new File(filePath).toPath());

            FileDownloadResponse response = new FileDownloadResponse();
            response.setFileData(fileData);
            response.setImageData(imageData);

            return response;
        } else {
            throw new ResourceNotFoundExeption("File not found with name: " + fileName);
        }
    }


}
