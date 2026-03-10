package com.cine.cine_reserva.exception_handling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Esta clase mdoela un manejador para Excepciones Rest
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method, send a response Entity Object, with teh parameters of
     * ApiExceptiob.
     * 
     * @param ex      The ApiException.
     * @param request The Web Request.
     * @return A Response Entity with the error details.
     */
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();

        response.setMessage(ex.getMessage());
        response.setStatus(ex.getStatus().value());
        response.setError(ex.getStatus());
        response.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return new ResponseEntity<>(response, response.getError());
    }
}
