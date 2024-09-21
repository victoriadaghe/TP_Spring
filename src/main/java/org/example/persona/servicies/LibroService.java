package org.example.persona.servicies;

import jakarta.transaction.Transactional;
import org.example.persona.entities.Libro;
import org.example.persona.repositories.LibroRepository;
import org.example.persona.servicies.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseService<Libro> {

    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
        try {
            List<Libro> entities = libroRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro findById(Long id) throws Exception {
        try {
            Optional<Libro> entity = libroRepository.findById(id);
            return entity.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try {
            entity = libroRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Optional<Libro> entityOptional = libroRepository.findById(id);
            Libro libro = entityOptional.get();
            libro = libroRepository.save(entity);
            return libro;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se puede eliminar el libro con id " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
