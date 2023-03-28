package com.pragma.plazoleta.application.dto.response;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoResponseDto {

    private Long id;
    private String nombre;
    private CategoriaModel categoria;
    private String descripcion;
    private Long precio;
    private RestauranteModel restaurante;
    private String urlLogo;
    private Boolean activo;
}
