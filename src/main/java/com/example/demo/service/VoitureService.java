package com.example.demo.service;
import com.example.demo.models.Passager;
import com.example.demo.models.Voiture;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface VoitureService {
	Voiture create(Voiture voiture);
	Voiture modify(Long id, Voiture voiture);
	List<Voiture> getAll();
	Optional<Voiture> getOneById(Long id);
	List<Voiture> findByKeyword(String keyword);
	List<Passager> getPassengers(Long id);
	void deleteById(Long id);
}
