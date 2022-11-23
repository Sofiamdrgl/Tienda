
package com.tienda.service;

import com.tienda.entity.Categorias;
import com.tienda.repository.CategoriasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepository CategoriasRepository;

    public List<Categorias> getALLcat(){
        return (List<Categorias>) CategoriasRepository.findAll();
    }
    public void savecat(Categorias Categorias){
        CategoriasRepository.save(Categorias);
    }
    public void delete(long id){
        CategoriasRepository.deleteById(id);
    }

    public Categorias getcatBylId(long id) {
        return CategoriasRepository.findById(id).orElse(null);
    }
}
