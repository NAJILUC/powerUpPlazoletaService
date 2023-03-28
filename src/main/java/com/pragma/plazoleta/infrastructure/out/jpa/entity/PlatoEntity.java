package com.pragma.plazoleta.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "platoTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "plato_id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @NotBlank(message = "La descripcion es obligatoria")
    @Column(length = 50)
    private String descripcion;

    @NotNull(message = "El nombre es obligatorio")
    @Min(1)
    @Column(length = 50)
    private Long precio;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestauranteEntity restaurante;

    @NotBlank(message = "La URL es obligatoria")
    @Column(length = 50)
    private String urlLogo;

    private Boolean activo;
}
