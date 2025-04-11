package com.ibrahim.platform.service;

import com.ibrahim.platform.domain.entities.Photo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface PhotoService {

    Photo uploadPhoto(MultipartFile fileName);
    Optional<Resource> getPhotoAsResource(String id);
}
