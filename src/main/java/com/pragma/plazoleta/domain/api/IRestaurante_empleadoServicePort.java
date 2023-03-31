package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;

import java.util.List;

public interface IRestaurante_empleadoServicePort {

    void saveRestaurante_empleado(Long idPropietario, Long idEmpleado);

    List<Restaurante_empleadoModel> getAllRestaurantes_empleados();
}