package com.example.demo.service;
import com.example.demo.models.Passager;
import com.example.demo.models.Voiture;
import com.example.demo.repository.VoitureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VoitureServiceImpl implements VoitureService {

	private final VoitureRepository vr;

	public VoitureServiceImpl(VoitureRepository vr) {
		this.vr = vr;
	}

	@Override
	public Voiture create(Voiture voiture) {
		return this.vr.save(voiture);
	}

	@Override
	public Voiture modify(Long id, Voiture voiture) {
		return this.vr.findById(id).map(carToModify -> {
			carToModify.setName(voiture.getName());
			carToModify.setColor(voiture.getColor());
			carToModify.setPrice(voiture.getPrice());
			return this.vr.save(carToModify);
		}).orElseThrow(() -> new RuntimeException("Not found Car."));
	}

	@Override
	public List<Voiture> getAll() {
		return this.vr.findAll();
	}

	@Override
	public Optional<Voiture> getOneById(Long id) {
		return this.vr.findById(id);
	}

	@Override
	public List<Voiture> findByKeyword(String keyword) {
		return this.vr.findByKeyword(keyword);
	}

	@Override
	public List<Passager> getPassengers(Long id) {
		Optional<Voiture> voiture = this.vr.findById(id);
		return voiture.map(Voiture::getPassagers).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		this.vr.deleteById(id);
	}
}
