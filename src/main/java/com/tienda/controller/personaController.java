package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.service.IPersonaService;
import com.tienda.service.IPaisService;

@Controller
public class personaController {

    @Autowired
    private IPersonaService  personaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getALLPersona();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }
    @GetMapping("/personaN")
    public String crearPersona(Model model){
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("Persona",new Persona());
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
}
