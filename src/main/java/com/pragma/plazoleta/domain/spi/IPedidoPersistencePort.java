package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;

import java.util.List;

public interface IPedidoPersistencePort {

    PedidoModel savePedido(PedidoModel pedidoModel);

    List<PedidoModel> getAllPedidos();
    List<PedidoModel> getAllPedidos(Integer page, Integer size);
    void deleteOrder(PedidoModel pedidoModel);

}