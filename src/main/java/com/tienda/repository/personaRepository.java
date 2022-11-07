
package com.tienda.repository;
import com.example.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personaRepository extends CrudRepository<Persona,Long>{

}
