package com.ibrahim.platform.exceptions;


public class Exception extends RuntimeException {

    public Exception() {
    }

    public Exception(Throwable cause) {
        super(cause);
    }

    public Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception(String message) {
        super(message);
    }
}
