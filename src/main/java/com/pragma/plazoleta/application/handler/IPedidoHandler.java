package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.PedidoRequestDto;

public interface IPedidoHandler {

    void savePedido(PedidoRequestDto pedidoRequestDto);
}
