package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.List;

@Entity
@Table(appliesTo = "passager")
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	@Column
	private int age;

	@Column
	private String numeroTelephone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voiture_id")
	private Voiture voiture;

	public Passager() {
		super();
	}

	public Passager(String nom, Integer age, String numeroTelephone) {
		super();
		this.nom = nom;
		this.age = age;
		this.numeroTelephone = numeroTelephone;
	}

	public String getNom() {
		return this.nom;
	}

	public Integer getAge() {
		return this.age;
	}

	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
}
