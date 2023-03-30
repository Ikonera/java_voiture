package com.example.demo.controller;
import com.example.demo.models.Passager;
import com.example.demo.service.PassagerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passagers")
public class PassagerController {

	private final PassagerService ps;

	public PassagerController(PassagerService ps) {
		this.ps = ps;
	}

	@PostMapping("/create")
	public Passager create(@RequestBody Passager passager) {
		return this.ps.create(passager);
	}

	@GetMapping("/getAll")
	public List<Passager> getAll() {
		return this.ps.getAll();
	}

	@GetMapping("/getId/{id}")
	public Optional<Passager> getId(@PathVariable Long id) {
		return this.ps.getOneById(id);
	}

	@PutMapping("/modify/{id}")
	public Passager modify(@PathVariable Long id, @RequestBody Passager passager) {
		return this.ps.modify(id, passager);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.ps.deleteById(id);
	}

}
