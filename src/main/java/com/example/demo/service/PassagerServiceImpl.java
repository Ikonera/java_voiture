package com.example.demo.service;

import com.example.demo.models.Passager;
import com.example.demo.repository.PassagerRepository;

import java.util.List;
import java.util.Optional;

public class PassagerServiceImpl implements PassagerService {
	public final PassagerRepository pr;

	public PassagerServiceImpl(PassagerRepository pr) {
		this.pr = pr;
	}

	@Override
	public Passager create(Passager passager) {
		return this.pr.save(passager);
	}

	@Override
	public Passager modify(Long id, Passager passager) {
		return this.pr.findById(id).map(passagerToModify -> {
			passagerToModify.setNom(passager.getNom());
			passagerToModify.setAge(passager.getAge());
			passagerToModify.setNumeroTelephone(passager.getNumeroTelephone());
			return this.pr.save(passagerToModify);
		}).orElseThrow(() -> new RuntimeException("Not found Passager."));
	}

	@Override
	public List<Passager> getAll() {
		return this.pr.findAll();
	}

	@Override
	public Optional<Passager> getOneById(Long id) {
		return this.pr.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		this.pr.deleteById(id);
	}
}
