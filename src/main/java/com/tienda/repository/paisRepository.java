
package com.tienda.repository;
import com.example.tienda.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository

public interface paisRepository extends CrudRepository<Pais,Long>{
    
}
