package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IRestauranteServicePort;
import com.pragma.plazoleta.domain.exception.DomainException;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;

    public RestauranteUseCase(IRestaurantePersistencePort objectPersistencePort) {
        this.restaurantePersistencePort = objectPersistencePort;
    }

    @Override
    public void saveRestaurante(RestauranteModel restauranteModel) {/*
        if(restauranteModel.getNombre().isEmpty())throw new DomainException("El nombre es obligatorio");
        if(restauranteModel.getNit().isEmpty())throw new DomainException("El nit es obligatorio");
        if(restauranteModel.getDireccion().isEmpty())throw new DomainException("La direccion es obligatoria");
        if(restauranteModel.getTelefono().isEmpty()||restauranteModel.getTelefono().length()<10||
                restauranteModel.getTelefono().length()>13)throw new DomainException("Ingrese un celular valido");
        if(restauranteModel.getUrlLogo().isEmpty())throw new DomainException("La Url del Logo es obligatoria");
        if(restauranteModel.getIdPropietario().toString().isEmpty())throw new DomainException("El id es obligatorio");*/
        restaurantePersistencePort.saveRestaurante(restauranteModel);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes(Integer page, Integer size) {
        return restaurantePersistencePort.getAllRestaurantes(page,size);
    }

}