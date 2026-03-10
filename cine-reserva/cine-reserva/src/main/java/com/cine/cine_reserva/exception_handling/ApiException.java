package com.cine.cine_reserva.exception_handling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Esta clase modela una API Exception
 */
@Setter
@Getter
public class ApiException extends RuntimeException {
    private final HttpStatus status;

    /**
     * Constructor method,
     * 
     * @param status  The status of the calling.
     * @param message The message to send.
     */
    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}