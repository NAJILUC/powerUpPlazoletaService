package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurante_empleadoPersistencePort;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedido_platoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestaurante_empleadoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Restaurante_empleadoJpaAdapter implements IRestaurante_empleadoPersistencePort {

    private final IRestaurante_empleadoRepository restaurante_empleadoRepository;

    @Override
    public Restaurante_empleadoModel saveRestaurante_empleado(Restaurante_empleadoModel restaurante_empleadoModel) {
        return null;
    }

    @Override
    public List<Restaurante_empleadoModel> getAllRestaurante_empleados() {
        return null;
    }
}