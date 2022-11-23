
package com.tienda.service;

import com.tienda.entity.articulos;
import com.tienda.repository.articulosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticulosService implements iArticulosService{
    @Autowired
    private articulosRepository articulosRepository;

    public List<articulos> getALLarticulos(){
        return (List<articulos>)articulosRepository.findAll();
    }
    public void savearticulos(articulos articulos){
        articulosRepository.save(articulos);
    }
    public void delete(long id){
        articulosRepository.deleteById(id);
    }

    public articulos getarticulosBylId(long id) {
        return articulosRepository.findById(id).orElse(null);
    }

    @Override
    public List<articulos> listArticulos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
