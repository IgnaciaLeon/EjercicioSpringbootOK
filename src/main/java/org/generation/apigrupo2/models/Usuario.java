package org.generation.apigrupo2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;


    @Column(name = "nombre")
    @NotNull
    private String usuarioNombre;

    @Column(name = "correo")
    @NotNull
    @Email
    private String usuarioCorreo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tarea> tareasUsuario;


}
