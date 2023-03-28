package com.pragma.plazoleta.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteResponseDto {
    private Long id;
    private String nombre;
    private Long nit;
    private String direccion;
    private String telefono;
    private String urlLogo;
    private Long idPropietario;
}
