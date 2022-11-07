package com.tienda.controller;

@Controller
public class personaController {

    @Autowired
    private IpersonaService personaService;

    @Autowired
    private IpaisService paisService;

    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
    }
