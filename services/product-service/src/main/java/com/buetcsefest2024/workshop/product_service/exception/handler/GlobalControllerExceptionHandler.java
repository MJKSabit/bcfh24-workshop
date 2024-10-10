package com.buetcsefest2024.workshop.product_service.exception.handler;


import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.buetcsefest2024.workshop.product_service.dto.ErrorMessageDto;
import com.buetcsefest2024.workshop.product_service.exception.handler.http.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Global Controller Exception Handler. This class maps exceptions to HTTP status codes
 */

@ControllerAdvice
@ResponseBody
public class GlobalControllerExceptionHandler {

    /**
     * Handle conflict.
     * This method maps DataIntegrityViolationException to HTTP status code 409
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorMessageDto handleConflict(DataIntegrityViolationException e) {
        return new ErrorMessageDto(e.getMessage(), "CONFLICT");
    }

    /**
     * Handle bad request.
     * <p>
     * This method maps IllegalArgumentException to HTTP status code 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            ConstraintViolationException.class,
            PropertyReferenceException.class,
            HttpMessageNotReadableException.class
    })
    public ErrorMessageDto handleBadRequest(Exception e) {
        return new ErrorMessageDto(e.getMessage(), "BAD_REQUEST");
    }

    /**
     * Handle method argument not valid.
     * This method maps MethodArgumentNotValidException to HTTP status code 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessageDto handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> messages.add(fieldError.getDefaultMessage()));
        // TODO: https://github.com/Pride-ERP-Cloud/security-module/issues/59
        return new ErrorMessageDto(String.join(", ", messages), "BAD_REQUEST");
    }


    /**
     * Handle internal server error.
     * This method maps all other exceptions that are not matched
     * with any other specific exception to HTTP status code 500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorMessageDto handleInternalServerError(Exception e) {
        return new ErrorMessageDto("Something went wrong. Please try again later", "INTERNAL_SERVER_ERROR");
    }
    /**
     * Handle not found exception.
     * This method maps NotFoundException to HTTP status code 404
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessageDto handleNotFoundException(NotFoundException e) {
        return new ErrorMessageDto(e.getMessage(), "NOT_FOUND");
    }

    /**
     * Handle security exception.
     * This method maps SecurityException to HTTP status code 403
     */
    // @ResponseStatus(HttpStatus.FORBIDDEN)
    // @ExceptionHandler(SecurityException.class)
    // public ErrorMessageDto handleSecurityException(SecurityException e) {
    //     return new ErrorMessageDto(e.getMessage(), "FORBIDDEN");
    // }

    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    // public ErrorMessageDto handleUnauthorizedException(InvalidDataAccessResourceUsageException e) {
    //     return new ErrorMessageDto("Invalid authorization headers", "UNAUTHORIZED");
    // }


}