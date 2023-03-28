package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;

import java.util.List;

public interface IPedidoServicePort {

    void savePedido(PedidoModel pedidoModel,List<Pedido_platoModel> pedido_platoModels);

    List<PedidoModel> getAllPedidos();
}