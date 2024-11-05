package com.portfolio.renato.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.renato.ecommerce.domain.Order;

/**
 * @author Renato Oliveira, Software Engineer
 */
public interface OrderRepository extends JpaRepository<Order, Long>{

	
	
}
