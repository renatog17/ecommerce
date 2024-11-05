package com.portfolio.renato.ecommerce.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.portfolio.renato.ecommerce.controllers.dto.CreateProductDTO;
import com.portfolio.renato.ecommerce.controllers.dto.ReadProductDTO;
import com.portfolio.renato.ecommerce.domain.Product;
import com.portfolio.renato.ecommerce.repositories.ProductRepository;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

/**
 * @author Renato Oliveira, Software Engineer
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@PostMapping
	public ResponseEntity<?> postProduct(@Valid @RequestBody CreateProductDTO createProductDTO, UriComponentsBuilder uriComponentsBuilder){
		Product product = new Product(createProductDTO); 
		productRepository.save(product);
		var uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ReadProductDTO(product));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ReadProductDTO(product.get()));
	}
	
}
