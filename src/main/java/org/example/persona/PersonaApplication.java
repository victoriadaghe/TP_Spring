package org.example.persona;


import org.example.persona.entities.Persona;
import org.example.persona.repositories.PersonaRepository;
import org.example.persona.entities.Domicilio;
import org.example.persona.repositories.DomicilioRepository;
import org.example.persona.entities.Localidad;
import org.example.persona.repositories.LocalidadRepository;
import org.example.persona.entities.Libro;
import org.example.persona.repositories.LibroRepository;
import org.example.persona.entities.Autor;
import org.example.persona.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class PersonaApplication implements CommandLineRunner {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(PersonaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Persona persona1 = new Persona();
        persona1.setNombre("Victoria");
        persona1.setApellido("Daghe");
        persona1.setDni(45782345);
        personaRepository.save(persona1);



        Domicilio domicilio1 = new Domicilio();
        domicilio1.setCalle("Rivadavia");
        domicilio1.setNumero(745);

        domicilioRepository.save(domicilio1);



        Localidad localidad = new Localidad();
        localidad.setDenominacion("Palmira");

        localidadRepository.save(localidad);


        domicilio1.setLocalidad(localidad);
        domicilioRepository.save(domicilio1);
        persona1.setDomicilio(domicilio1);






    }




}
