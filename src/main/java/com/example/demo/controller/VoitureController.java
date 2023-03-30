package com.example.demo.controller;
import com.example.demo.models.Voiture;
import com.example.demo.service.VoitureService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

	private final VoitureService vs;

	public VoitureController(VoitureService vs) {
		this.vs = vs;
	}

	@PostMapping("/create")
	public Voiture create(@RequestBody Voiture voiture) {
		return this.vs.create(voiture);
	}

	@GetMapping("/getAll")
	public List<Voiture> getAll() {
		return this.vs.getAll();
	}

	@GetMapping("/getId/{id}")
	public Optional<Voiture> getId(@PathVariable Long id) {
		return this.vs.getOneById(id);
	}

	@GetMapping("/search/{keyword}")
	public List<Voiture> search(@PathVariable String keyword) {
		if (keyword.isEmpty()) return this.vs.getAll();
		return this.vs.findByKeyword(keyword);
	}

	@PutMapping("/modify/{id}")
	public Voiture modify(@PathVariable Long id, @RequestBody Voiture voiture) {
		return this.vs.modify(id, voiture);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.vs.deleteById(id);
	}

}
