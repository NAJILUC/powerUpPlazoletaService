package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.response.Restaurante_empleadoResponseDto;
import com.pragma.plazoleta.application.handler.IRestaurante_empleadoHandler;
import com.pragma.plazoleta.application.mapper.IRestaurante_empleadoResponseMapper;
import com.pragma.plazoleta.domain.api.IRestaurante_empleadoServicePort;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Restaurante_empleado_Handler implements IRestaurante_empleadoHandler {

    private final IRestaurante_empleadoResponseMapper restaurante_empleadoResponseMapper;
    private final IRestaurante_empleadoServicePort restaurante_empleadoServicePort;

    @Override
    public List<Restaurante_empleadoResponseDto> getAllRestaurante_empleados() {
        return restaurante_empleadoResponseMapper.toResponseList(restaurante_empleadoServicePort.getAllRestaurantes_empleados());
    }

    @Override
    public void saveRestaurante_Empleado(Long idPropietario, Long idEmpleado) {
        restaurante_empleadoServicePort.saveRestaurante_empleado(idPropietario,idEmpleado);
    }
}
