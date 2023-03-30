package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "passager")
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nom;

	@Column
	private Integer age;

	@Column
	private String telephone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voiture_id")
	private Voiture voiture;

	public Passager() { super(); }

	public Passager(String nom, Integer age, String telephone) {
		super();
		this.nom = nom;
		this.age = age;
		this.telephone = telephone;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return this.age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
