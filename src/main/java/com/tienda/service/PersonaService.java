package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personalRepository;

    @Override
    public List<Persona> getALLPersona() {
        return (List<Persona>) personalRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personalRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personalRepository.deleteById(id);
    }

    @Override
    public Persona getPersonaBylId(long id) {
        return personalRepository.findById(id).orElse(null);
    }

    @Override
    public Persona findByNombre(String nombre) {
        return personalRepository.findByNombre(nombre);

    }
    
}
