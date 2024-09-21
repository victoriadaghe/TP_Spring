package org.example.persona.repositories;

import org.example.persona.entities.Libro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
