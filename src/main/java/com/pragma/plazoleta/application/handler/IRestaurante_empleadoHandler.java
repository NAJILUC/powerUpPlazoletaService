package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.response.Restaurante_empleadoResponseDto;

import java.util.List;

public interface IRestaurante_empleadoHandler {

    List<Restaurante_empleadoResponseDto> getAllRestaurante_empleados();
    void saveRestaurante_Empleado(Long idPropietario, Long idEmpleado);
}
