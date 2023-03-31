package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;

import java.util.List;

public interface IPedidoServicePort {

    void savePedido(PedidoModel pedidoModel,List<Pedido_platoModel> pedido_platoModels);

    List<PedidoModel> getAllPedidos();
    List<PedidoModel> getAllPedidos(Integer page, Integer size);
    void proccesMessage(MessageRequestDto messageRequestDto, Long idCliente);
    void assignEmployed(Long idPedido);
    void deliverOrder(Long idPedido, Long pin);
    void cancelOrder(Long idPedido);
}