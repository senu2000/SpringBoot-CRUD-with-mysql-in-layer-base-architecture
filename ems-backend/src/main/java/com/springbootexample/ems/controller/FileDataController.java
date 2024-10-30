package com.springbootexample.ems.controller;

import com.springbootexample.ems.dto.FileDownloadResponse;
import com.springbootexample.ems.service.impl.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/file")
public class FileDataController {
    @Autowired
    private StorageService service;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

//    @GetMapping("/fileSystem/{fileName}")
//    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
//        byte[] imageData=service.downloadImageFromFileSystem(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//
//    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageWithDetailsFromFileSystem(@PathVariable String fileName) throws IOException {
        FileDownloadResponse downloadResponse = service.downloadImageWithDetailsFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(downloadResponse);
    }

}
