package com.pragma.plazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RestauranteRequestDto {


    @NotEmpty(message = "El nombre es obligatorio")
    @Pattern(regexp = "^(?=.*[a-zA-Z])[0-9a-zA-Z ]+$", message = "Ingrese un nombre valido")
    private String nombre;
    @NotEmpty(message = "El nit es obligatorio")
    @Pattern(regexp = "^\\d{1,12}$", message = "Ingrese un nit valido")
    @Min(value = 1, message = "Ingrese un nit valido")
    private String nit;
    @NotEmpty(message = "La direccion es obligatoria")
    private String direccion;
    @NotEmpty(message = "El telefono es obligatorio")
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Ingrese un numero de telefono valido")
    private String telefono;
    @NotEmpty(message = "La URL es obligatorio")
    private String urlLogo;
    @Null(message = "El id es obligatorio")
    private Long idPropietario;
}
