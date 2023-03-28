package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;

import java.util.List;

public interface IRestaurante_empleadoPersistencePort {

    Restaurante_empleadoModel saveRestaurante_empleado(Restaurante_empleadoModel restaurante_empleadoModel);

    List<Restaurante_empleadoModel> getAllRestaurante_empleados();
}