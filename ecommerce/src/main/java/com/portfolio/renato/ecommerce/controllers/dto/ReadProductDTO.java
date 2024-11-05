package com.portfolio.renato.ecommerce.controllers.dto;

import java.math.BigDecimal;

import com.portfolio.renato.ecommerce.domain.Product;

public record ReadProductDTO(
		String name,
		String description,
		BigDecimal unitPrice,
		Integer quantity) {

	public ReadProductDTO(Product product) {
		this(
				product.getName(), 
				product.getDescription(), 
				product.getUnitPrice(), 
				product.getQuantity());
	}

}
