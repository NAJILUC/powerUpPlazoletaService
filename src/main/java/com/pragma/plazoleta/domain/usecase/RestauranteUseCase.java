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
    public void saveRestaurante(RestauranteModel restauranteModel) {
        restaurantePersistencePort.saveRestaurante(restauranteModel);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes(Integer page, Integer size) {
        return restaurantePersistencePort.getAllRestaurantes(page,size);
    }

}