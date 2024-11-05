package com.portfolio.renato.ecommerce.controllers.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateProductDTO(
		@NotNull
		@NotEmpty
		String name,
		@NotNull
		@NotEmpty
		String description,
		@NotNull
		@DecimalMin(value = "0.01", inclusive = true, message = "Unit price must be greater than 0")
		BigDecimal unitPrice,
		@NotNull
		@Min(value = 0, message = "Quantity must be 0 or greater")
		Integer quantity) {
}
