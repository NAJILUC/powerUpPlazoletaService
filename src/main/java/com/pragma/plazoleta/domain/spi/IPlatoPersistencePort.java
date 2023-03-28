package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoPersistencePort {
    PlatoModel savePlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlatos();

    List<PlatoModel> getAllPlatosRestaurant(Integer page, Integer size);
}