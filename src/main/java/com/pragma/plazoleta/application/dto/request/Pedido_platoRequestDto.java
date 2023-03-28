package com.pragma.plazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido_platoRequestDto {

    Long id_pedido;
    Long id_plato;
    Long cantidad;
}
