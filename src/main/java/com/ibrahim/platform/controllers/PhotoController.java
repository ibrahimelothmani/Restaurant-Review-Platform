package com.ibrahim.platform.controllers;


import com.ibrahim.platform.domain.dtos.PhotoDto;
import com.ibrahim.platform.domain.entities.Photo;
import com.ibrahim.platform.mappers.PhotoMapper;
import com.ibrahim.platform.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id:.+}")
    public ResponseEntity<Resource> getPhoto(@RequestParam("id") String id) {
       return photoService.getPhotoAsResource(id).map(photo ->
                        ResponseEntity.ok()
                                .contentType(
                                        MediaTypeFactory.getMediaType(photo)
                                        .orElse(MediaType.APPLICATION_OCTET_STREAM)
                                )
                                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                                .body(photo))
                .orElse(ResponseEntity.notFound().build());
    }
}
