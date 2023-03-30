package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(appliesTo = "voiture")
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private Float price;
	@Column
	private String color;

	@OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Passager> passagers = new ArrayList<>();

	public Voiture() {
		super();
	}

	public Voiture(String name, String color, Float price) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
	public void setColor(String color) { this.color = color;}

	public String getName() {
		return this.name;
	}
	public void setName(String name) { this.name = name;}

	public Float getPrice() {
		return this.price;
	}
	public void setPrice(Float price) { this.price = price;}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
