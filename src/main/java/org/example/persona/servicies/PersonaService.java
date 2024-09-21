package org.example.persona.servicies;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import org.example.persona.entities.Persona;
import org.example.persona.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
       this.personaRepository = personaRepository; }


    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {

            List<Persona> entities = personaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entity = personaRepository.findById(id);
            return entity.get();


        } catch (Exception e) { throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
        entity = personaRepository.save(entity);
        return entity;

        } catch (Exception e) { throw new Exception(e.getMessage()); }

    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
                return true;

            } else {
                throw new Exception("No se puede eliminar la persona con id " + id);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
