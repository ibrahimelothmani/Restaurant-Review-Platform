package com.ibrahim.platform.service.Impl;

import com.ibrahim.platform.exceptions.StorageException;
import com.ibrahim.platform.service.StorageService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Service
@Slf4j
public class FileSystemStorageService implements StorageService {

    @Value("${app.storage.location}")
    private String storageLocation;

    private Path rootLocation;

    @PostConstruct
    public void init() {
         rootLocation = Paths.get(storageLocation);

        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage location ",e);
        }
    }

    @Override
    public String store(MultipartFile file, String fileName) {
        if(file.isEmpty()) {
            throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
        }
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fileNameWithExtension = fileName + "." + extension;
        try {
            Path destinationFile = rootLocation.resolve(Paths.get(fileNameWithExtension))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(rootLocation.toAbsolutePath())) {
                throw new StorageException("Cannot store file outside current directory " + fileNameWithExtension);
            }
            Files.copy(file.getInputStream(), destinationFile);
            return fileNameWithExtension;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + fileNameWithExtension, e);
        }
    }

    @Override
    public Optional<Resource> loadAsResource(String fileName) {

        try {
            Path file = rootLocation.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return Optional.of(resource);
            } else {
                return Optional.empty();
            }
        } catch (MalformedURLException e) {
            log.warn("Could not read file: %s".formatted(fileName), e);
            return Optional.empty();
        }
    }
}
