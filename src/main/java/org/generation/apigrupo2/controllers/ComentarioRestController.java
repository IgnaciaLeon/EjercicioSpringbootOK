package org.generation.apigrupo2.controllers;

import org.generation.apigrupo2.models.Comentario;
import org.generation.apigrupo2.models.Tarea;
import org.generation.apigrupo2.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")

public class ComentarioRestController {

    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/lista")
    public List<Comentario> listaComentarios() {
        List<Comentario> mostrarListaComentario = comentarioService.listaDeComentarios();
        return mostrarListaComentario;
    }

    @PostMapping("/nuevo")
    public Comentario guardarComentario (@RequestBody Comentario nuevoComentario) {
        Comentario comentarioAGuardar = comentarioService.guardarComentario(nuevoComentario);
        return comentarioAGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarComentarioPorId(@PathVariable Long id){
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id, @RequestBody Comentario comentarioActualizado){
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizado);
        return comentarioEditado;
    }

    @GetMapping("/buscar/{id}")
    public Comentario comentarioPorId(@PathVariable Long id){
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }



}
