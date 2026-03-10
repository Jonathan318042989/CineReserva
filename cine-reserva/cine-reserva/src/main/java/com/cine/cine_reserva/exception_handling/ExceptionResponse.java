package com.cine.cine_reserva.exception_handling;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Esta clase modela la respuesta de una Excepcion
 */
@Setter
@Getter
public class ExceptionResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private Integer status;
    private HttpStatus error;
    private String message;
    private String path;

    /**
     * Constructor Method.
     */
    public ExceptionResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    /**
     * Constructor method.
     * 
     * @param timeStamp The time stamp of error.
     * @param status    The status for the Exception Response.
     * @param message   The message for the Exception Response.
     * @param error     The error for the Exception Response.
     * @param path      The path from error.
     */
    public ExceptionResponse(LocalDateTime timeStamp, Integer status, String message, HttpStatus error, String path) {
        super();
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

}
