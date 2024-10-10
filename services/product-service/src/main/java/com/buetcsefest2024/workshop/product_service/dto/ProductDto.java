package com.buetcsefest2024.workshop.product_service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDto(
        @NotNull(message = "Id is required")
        long id,
        @NotNull(message = "Name is required")
        @NotEmpty(message = "Name is required")
        String name,
        @NotNull(message = "Price is required")
        double price,
        String description,
        @NotNull(message = "Image is required")
        String image
) {
}
