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

    @Column(length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @Column(length = 50)
    private String descripcion;

    @Min(1)
    @Column(length = 50)
    private Long precio;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestauranteEntity restaurante;

    @Column(length = 50)
    private String urlLogo;

    private Boolean activo;
}
