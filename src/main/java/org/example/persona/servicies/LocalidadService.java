package org.example.persona.servicies;



import jakarta.transaction.Transactional;
import org.example.persona.entities.Localidad;
import org.example.persona.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad> {

    private LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try {
            List<Localidad> entities = localidadRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(Long id) throws Exception {
        try {
            Optional<Localidad> entity = localidadRepository.findById(id);
            return entity.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try {
            entity = localidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            Localidad localidad = entityOptional.get();
            localidad = localidadRepository.save(entity);
            return localidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)) {
                localidadRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se puede eliminar la localidad con id " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
