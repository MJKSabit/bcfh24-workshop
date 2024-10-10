package com.buetcsefest2024.workshop.product_service.dto;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/*
{
    "id": 0,
    "name": "Where My Dogs At Collar Tag",
    "price": 5.99,
    "description": "Ensure your furry friend always finds their way home with this Where My Dogs At Collar Tag. This tag is made of durable metal and features a fun design that will make your dog the talk of the town. It also includes a metal ring that makes it easy to attach to your dog's collar.",
    "image": "/placeholder.png"
}
 */
public record ProductInsertDto(
        @NotNull(message = "Name is required")
        @NotEmpty(message = "Name is required")
        String name,
        @NotNull(message = "Price is required")
        double price,
        String description,
        @NotNull(message = "Image is required")
        @Value("./placeholder.png")
        String image
        
) {
}

