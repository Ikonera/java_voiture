package com.example.demo.service;
import com.example.demo.models.Passager;
import com.example.demo.repository.PassagerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassagerServiceImpl implements PassagerService {

	private final PassagerRepository pr;

	public PassagerServiceImpl(PassagerRepository pr) {
		this.pr = pr;
	}

	@Override
	public Passager create(Passager passager) {
		return null;
	}

	@Override
	public Passager modify(Long id, Passager passager) {
		return null;
	}

	@Override
	public List<Passager> getAll() {
		return null;
	}

	@Override
	public Optional<Passager> getOneById(Long id) {
		return Optional.empty();
	}

	@Override
	public void deleteById(Long id) {

	}
}
