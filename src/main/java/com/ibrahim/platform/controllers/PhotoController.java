package com.ibrahim.platform.controllers;


import com.ibrahim.platform.domain.dtos.PhotoDto;
import com.ibrahim.platform.domain.entities.Photo;
import com.ibrahim.platform.mappers.PhotoMapper;
import com.ibrahim.platform.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/photos")

public class PhotoController {

    private final PhotoService photoService;
    private final PhotoMapper photoMapper;

    @PostMapping
    public ResponseEntity<PhotoDto> uploadPhoto(@RequestParam("file") MultipartFile file) {
        Photo photo = photoService.uploadPhoto(file);
        PhotoDto photoDto = photoMapper.toDto(photo);
        return ResponseEntity.ok(photoDto);
    }
}
