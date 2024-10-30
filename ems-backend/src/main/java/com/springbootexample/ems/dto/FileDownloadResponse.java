package com.springbootexample.ems.dto;

import com.springbootexample.ems.entity.FileData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDownloadResponse {
    private FileData fileData;
    private byte[] imageData;
}
