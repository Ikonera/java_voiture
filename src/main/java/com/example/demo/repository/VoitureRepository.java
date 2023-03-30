package com.example.demo.repository;
import com.example.demo.models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
	@Query("SELECT cars FROM Voiture cars WHERE CONCAT(cars.name, cars.color, cars.price) LIKE %?1%")
	List<Voiture> findByKeyword(String keyword);
}