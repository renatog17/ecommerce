package com.portfolio.renato.ecommerce.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idUsuario; 
	private LocalDateTime dateTime;
	@ManyToMany
	@JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products = new ArrayList<Product>();
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long idUsuario, LocalDateTime dateTime) {
		super();
		this.idUsuario = idUsuario;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", idUsuario=" + idUsuario + ", dateTime=" + dateTime + "]";
	}

	
	
}
