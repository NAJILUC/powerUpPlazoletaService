package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoServicePort {

    void savePlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlatos();

    PlatoModel getPlatoById(Long id);

    void updatePlato(PlatoModel platoModel);
    void statusPlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlatosRestaurant(Long restaurante, Integer page, Integer size);
}