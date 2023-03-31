package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.spi.ICategoriaPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NoDataFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.CategoriaEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.PedidoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPedidoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.ICategoriaRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PedidoJpaAdapter implements IPedidoPersistencePort {

    private final IPedidoRepository pedidoRepository;

    private final IPedidoEntityMapper pedidoEntityMapper;

    @Override
    public PedidoModel savePedido(PedidoModel pedidoModel) {
        PedidoEntity pedidoEntity = pedidoRepository.save(pedidoEntityMapper.toPedidoEntity(pedidoModel));
        return pedidoEntityMapper.toPedidoModel(pedidoEntity);
    }

    @Override
    public List<PedidoModel> getAllPedidos() {
        return pedidoEntityMapper.toPedidoModelList(pedidoRepository.findAll());
    }

    @Override
    public List<PedidoModel> getAllPedidos(Integer page, Integer size) {
        List<PedidoEntity> entityList = new ArrayList<>();

        Page<PedidoEntity> entityPage = pedidoRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"estado")));
        for (PedidoEntity pedido: entityPage) {
            entityList.add(pedido);
        }
        if(entityList.isEmpty()) throw new NoDataFoundException();
        return pedidoEntityMapper.toPedidoModelList(entityList);
    }

    @Override
    public void deleteOrder(PedidoModel pedidoModel) {
        pedidoRepository.delete(pedidoEntityMapper.toPedidoEntity(pedidoModel));
    }

}