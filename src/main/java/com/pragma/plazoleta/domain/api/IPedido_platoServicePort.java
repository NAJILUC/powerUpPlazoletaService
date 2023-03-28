package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.Pedido_platoModel;

import java.util.List;

public interface IPedido_platoServicePort {

    void savePedido_plato(Pedido_platoModel pedidoplatoModel);

    List<Pedido_platoModel> getAllPedidos_platos();
}