package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;

import java.util.List;

public interface IPedidoHandler {

    void savePedido(PedidoRequestDto pedidoRequestDto);
    List<PedidoResponseDto> getAllPpedidos(Integer page, Integer size);
    void proccesMessage(MessageRequestDto messageRequestDto, Long idCliente);
    void assignEmployed(Long idPedido);
    void deliverOrder(Long idPedido, Long pin);
    void cancelOrder(Long idPedido);
}
