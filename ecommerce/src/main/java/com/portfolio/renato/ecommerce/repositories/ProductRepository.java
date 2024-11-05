package com.portfolio.renato.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.renato.ecommerce.domain.Product;

/**
 * @author Renato Oliveira, Software Engineer
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	
}
