package com.pragma.plazoleta.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categoriaTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoria_id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(length = 50)
    private String nombre;

    @NotBlank(message = "La descripcion es obligatoria")
    @Column(length = 50)
    private String descripcion;

}
