package com.portfolio.renato.ecommerce.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.portfolio.renato.ecommerce.controllers.dto.CreateProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * @author Renato Oliveira, Software Engineer
 */
@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private BigDecimal unitPrice;
	private Integer quantity;
	@ManyToMany(mappedBy = "products")
	private List<Order> orders = new ArrayList<Order>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String description, BigDecimal unitPrice, Integer quantity) {
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Product(CreateProductDTO createProductDTO) {
		this.name = createProductDTO.name();
		this.description = createProductDTO.description();
		this.unitPrice = createProductDTO.unitPrice();
		this.quantity = createProductDTO.quantity();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + "]";
	}

}
