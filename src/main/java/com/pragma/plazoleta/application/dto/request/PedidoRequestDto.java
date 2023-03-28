package com.pragma.plazoleta.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PedidoRequestDto {

    Long idRestaurante;
    List<Map<Long,Long>> platoCantidad;
    String estado;
}
