package com.example.demo.service;
import com.example.demo.models.Passager;

import java.util.List;
import java.util.Optional;

public interface PassagerService {
	Passager create(Passager passager);
	Passager modify(Long id, Passager passager);
	List<Passager> getAll();
	Optional<Passager> getOneById(Long id);
	void deleteById(Long id);
}
