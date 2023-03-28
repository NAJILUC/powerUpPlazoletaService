package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoStatusRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoUpdateRequestDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;

import java.util.List;

public interface IPlatoHandler {

    void savePlato(PlatoRequestDto platoRequestDto);

    List<PlatoResponseDto> getAllPlatos();

    PlatoResponseDto getPlatoById(Long id);

    void updatePlato(PlatoUpdateRequestDto platoUpdateRequestDto);

    void statusPlato(PlatoStatusRequestDto platoStatusRequestDto);

    List<PlatoResponseDto> getAllPlatosRestaurant(Long restaurante, Integer page, Integer size);
}