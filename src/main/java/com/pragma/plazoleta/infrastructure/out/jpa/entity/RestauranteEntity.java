package com.pragma.plazoleta.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "restauranteTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestauranteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurante_id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^(?=.*[a-zA-Z])[0-9a-zA-Z ]+$", message = "Ingrese un nombre valido")
    @Column(length = 50)
    private String nombre;

    @NotBlank(message = "El nit es obligatorio")
    @Pattern(regexp = "^\\d{1,12}$", message = "Ingrese un nit valido")
    @Min(value = 1, message = "Ingrese un nit valido")
    @Column(length = 50)
    private String nit;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(length = 50)
    private String direccion;

    @NotBlank(message = "El telefono es obligatorio")
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Ingrese un numero de telefono valido")
    @Min(1)
    @Column(length = 15)
    private String telefono;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(length = 50)
    private String urlLogo;

    @NotNull(message = "El nombre es obligatorio")
    @Column(length = 50)
    private Long idPropietario;
}
