package com.pragma.plazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoUpdateRequestDto {

    private Long id;
    private String descripcion;
    private Long precio;
}
