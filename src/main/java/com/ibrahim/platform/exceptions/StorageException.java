package com.ibrahim.platform.exceptions;

public class StorageException extends Exception{

    public StorageException() {
    }

    public StorageException(Throwable cause) {
        super(cause);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageException(String message) {
        super(message);
    }
}
