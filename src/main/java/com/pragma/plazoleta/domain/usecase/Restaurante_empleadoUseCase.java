package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IRestaurante_empleadoServicePort;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.domain.spi.IRestaurante_empleadoPersistencePort;

import java.util.List;

public class Restaurante_empleadoUseCase implements IRestaurante_empleadoServicePort {

    private final IRestaurante_empleadoPersistencePort restaurante_empleadoPersistencePort;
    private final RestauranteUseCase restauranteUseCase;

    public Restaurante_empleadoUseCase(IRestaurante_empleadoPersistencePort restaurante_empleadoPersistencePort, RestauranteUseCase restauranteUseCase) {
        this.restaurante_empleadoPersistencePort = restaurante_empleadoPersistencePort;
        this.restauranteUseCase = restauranteUseCase;
    }

    @Override
    public void saveRestaurante_empleado(Long idPropietario, Long idEmpleado) {
        Restaurante_empleadoModel restaurante_empleadoModel = null;
        List<RestauranteModel> restaurantes = restauranteUseCase.getAllRestaurantes(0,Integer.MAX_VALUE);
        for (RestauranteModel restaurante: restaurantes) {
            if(restaurante.getIdPropietario()==idPropietario){
                restaurante_empleadoModel = new Restaurante_empleadoModel(restaurante.getId(),idEmpleado);
                restaurante_empleadoPersistencePort.saveRestaurante_empleado(restaurante_empleadoModel);
                return;
            }
        }

    }

    @Override
    public List<Restaurante_empleadoModel> getAllRestaurantes_empleados() {
        return restaurante_empleadoPersistencePort.getAllRestaurante_empleados();
    }
}
