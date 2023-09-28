package org.generation.apigrupo2.controllers;

import org.generation.apigrupo2.models.Tarea;
import org.generation.apigrupo2.models.Usuario;
import org.generation.apigrupo2.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")

public class TareaRestController {

    @Autowired
    TareaServiceImpl tareaService;


    @GetMapping("/lista")
    public List<Tarea> listaTareas() {
        List<Tarea> mostrarListaTareas = tareaService.listaDeTarea();
        return mostrarListaTareas;
    }

    @PostMapping("/nuevo")
    public Tarea guardarTarea(@RequestBody Tarea nuevaTarea) {
        Tarea tareaAGuardar = tareaService.guardarTarea(nuevaTarea);
        return tareaAGuardar;
    }



    }

