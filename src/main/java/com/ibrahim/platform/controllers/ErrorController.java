package com.ibrahim.platform.controllers;


import com.ibrahim.platform.domain.dtos.ErrorDto;
import com.ibrahim.platform.exceptions.BaseException;
import com.ibrahim.platform.exceptions.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j

public class ErrorController {

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ErrorDto> handleException(StorageException e) {
        log.error("An error occurred: {}", e.getMessage());
        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred")
                .build();
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDto> handleException(BaseException e) {
        log.error("An error occurred: {}", e.getMessage());
        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred")
                .build();
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        log.error("An error occurred: {}", e.getMessage());
        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred")
                .build();
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }
}
