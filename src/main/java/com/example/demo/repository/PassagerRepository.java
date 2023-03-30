package com.example.demo.repository;

import com.example.demo.models.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRepository extends JpaRepository<Passager, Long> {
}
