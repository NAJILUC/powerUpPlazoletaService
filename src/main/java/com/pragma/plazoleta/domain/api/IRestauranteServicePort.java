package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.RestauranteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRestauranteServicePort {

    void saveRestaurante(RestauranteModel restauranteModel);

    List<RestauranteModel> getAllRestaurantes(Integer page, Integer size);
}