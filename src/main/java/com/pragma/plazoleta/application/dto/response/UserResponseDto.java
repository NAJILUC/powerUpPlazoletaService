package com.pragma.plazoleta.application.dto.response;

import com.pragma.plazoleta.domain.model.RolModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String celular;
    private String correo;
    private String clave;
    private RolModel rol;
}
