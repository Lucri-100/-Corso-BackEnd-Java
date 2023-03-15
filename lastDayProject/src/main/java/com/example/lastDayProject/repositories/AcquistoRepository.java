package com.example.lastDayProject.repositories;

import com.example.lastDayProject.entities.Acquisto;
import com.example.lastDayProject.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcquistoRepository extends JpaRepository<Acquisto,Integer> {
}
