package com.pragma.plazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

@Getter
@Setter
public class PlatoRequestDto {

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;
    @Null(message = "El id de la categoria es obligatorio")
    private Long categoria;
    @NotEmpty(message = "la descripcion es obligatoria")
    private String descripcion;
    @Null(message = "El precio es obligatorio")
    private Long precio;
    @Null(message = "El ide del Restaurante es obligatorio")
    private Long restaurante;
    @NotEmpty(message = "La URL del logo esobligatoria")
    private String urlLogo;
}
