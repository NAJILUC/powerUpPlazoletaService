package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedido_platoPersistencePort;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.Pedido_platoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPedido_platoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedidoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedido_platoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Pedido_platoJpaAdapter implements IPedido_platoPersistencePort {

    private final IPedido_platoRepository pedido_platoRepository;

    private final IPedido_platoEntityMapper pedido_platoEntityMapper;

    @Override
    public Pedido_platoModel savePedido_plato(Pedido_platoModel pedido_platoModel) {
        Pedido_platoEntity pedido_platoEntity = pedido_platoRepository.save(pedido_platoEntityMapper.toPedido_platoEntity(pedido_platoModel));
        return pedido_platoEntityMapper.toPedido_platoModel(pedido_platoEntity);
    }

    @Override
    public List<Pedido_platoModel> getAllPedido_platos() {
        return pedido_platoEntityMapper.toPedido_platoModelList(pedido_platoRepository.findAll());
    }
}