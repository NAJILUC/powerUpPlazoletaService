package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurante_empleadoPersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NoDataFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.Restaurante_empleadoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestaurante_empleadoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedido_platoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestaurante_empleadoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Restaurante_empleadoJpaAdapter implements IRestaurante_empleadoPersistencePort {

    private final IRestaurante_empleadoRepository restaurante_empleadoRepository;
    private final IRestaurante_empleadoEntityMapper restaurante_empleadoEntityMapper;

    @Override
    public Restaurante_empleadoModel saveRestaurante_empleado(Restaurante_empleadoModel restaurante_empleadoModel) {
        Restaurante_empleadoEntity restaurante_empleadoEntity = restaurante_empleadoRepository.save(restaurante_empleadoEntityMapper.toEntity(restaurante_empleadoModel));
        return restaurante_empleadoEntityMapper.toModel(restaurante_empleadoEntity);
    }

    @Override
    public List<Restaurante_empleadoModel> getAllRestaurante_empleados() {
        List<Restaurante_empleadoEntity> entityList = restaurante_empleadoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurante_empleadoEntityMapper.toRestaurante_empleadoModelList(entityList);
    }
}