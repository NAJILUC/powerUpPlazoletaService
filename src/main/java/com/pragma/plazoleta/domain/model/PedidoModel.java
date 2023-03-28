package com.pragma.plazoleta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {
    private Long id;
    private Long cliente;
    private Date fecha;
    private String estado;
    private Restaurante_empleadoModel id_chef;
    private RestauranteModel id_restaurante;
}
