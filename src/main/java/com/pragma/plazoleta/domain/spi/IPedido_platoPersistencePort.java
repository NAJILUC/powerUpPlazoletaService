package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;

import java.util.List;

public interface IPedido_platoPersistencePort {

    Pedido_platoModel savePedido_plato(Pedido_platoModel pedido_platoModel);

    List<Pedido_platoModel> getAllPedido_platos();
}