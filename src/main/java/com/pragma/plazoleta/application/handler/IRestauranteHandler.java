package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRestauranteHandler {

    void saveRestaurante(RestauranteRequestDto restauranteRequestDto);

    List<RestauranteResponseDto> getAllRestaurantes(Integer page, Integer size);

}