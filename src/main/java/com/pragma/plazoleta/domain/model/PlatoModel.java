package com.pragma.plazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoModel {
    private Long id;
    private String nombre;
    private CategoriaModel categoria;
    private String descripcion;
    private Long precio;
    private RestauranteModel restaurante;
    private String urlLogo;
    private Boolean activo;
}
