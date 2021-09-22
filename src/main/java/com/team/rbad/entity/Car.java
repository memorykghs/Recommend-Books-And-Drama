package com.team.rbad.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CARS")
@IdClass(value = CarPK.class)
@Data
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	
	@Id
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "MIN_PRICE")
	private BigDecimal minPrice;
	
	@Column(name = "PRICE")
	private BigDecimal price;
}
