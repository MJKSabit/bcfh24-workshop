package com.buetcsefest2024.workshop.product_service.exception.handler.http;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}