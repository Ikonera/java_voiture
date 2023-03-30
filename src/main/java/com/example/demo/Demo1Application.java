package com.example.demo;
import com.example.demo.models.Passager;
import com.example.demo.models.Voiture;
import com.example.demo.repository.PassagerRepository;
import com.example.demo.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	VoitureRepository vr;
	@Autowired
	PassagerRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Voiture> voitures = new ArrayList<>();
		Random random = new Random();

		String[] colors = {"Red", "Blue", "Green", "Yellow", "Black", "White"};
		String[] names = {"Ferrari", "Porsche", "Lamborghini", "Audi", "BMW", "Mercedes-Benz", "Ford", "Chevrolet", "Toyota", "Honda"};

		for (int i = 0; i < 50; i++) {
			String name = names[random.nextInt(names.length)];
			String color = colors[random.nextInt(colors.length)];
			Float price = (float) (random.nextInt(100000) + 10000);
			Voiture voiture = new Voiture(name, color, price);

			vr.save(voiture);

			int numPassagers = random.nextInt(11) + 20;

			for (int j = 0; j < numPassagers; j++) {
				String nom = "Passager " + (j + 1);
				Integer age = random.nextInt(11) + 20;
				String telephone = "555-555-" + String.format("%04d", random.nextInt(10000));
				Passager passager = new Passager(nom, age, telephone);

				passager.setVoiture(voiture);
				pr.save(passager);
			}
		}

		System.out.println("Generated " + voitures.size() + " voitures:");

		for (Voiture voiture : voitures) {
			System.out.println(voiture.getName() + " (" + voiture.getColor() + ") - " + voiture.getPrice() + " $");

			System.out.println("  Passagers:");
			for (Passager passager : voiture.getPassagers()) {
				System.out.println("    " + passager.getNom() + " (" + passager.getAge() + " ans, " + passager.getTelephone() + ")");
			}

			System.out.println();
		}
	}
}
