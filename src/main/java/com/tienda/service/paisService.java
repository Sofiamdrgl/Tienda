
package com.tienda.service;
import com.tienda.entity.Pais;
import com.tienda.repository.paisRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class paisService implements IPaisService {

    @Autowired
    private paisRepository paisRepository;

    @Override
    public List<Pais> listCountry() {
        return (List<Pais>) paisRepository.findAll();
    }
}