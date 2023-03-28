package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoStatusRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoUpdateRequestDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.application.handler.IPlatoHandler;
import com.pragma.plazoleta.application.mapper.IPlatoRequestMapper;
import com.pragma.plazoleta.application.mapper.IPlatoResponseMapper;
import com.pragma.plazoleta.domain.api.IPlatoServicePort;
import com.pragma.plazoleta.domain.model.PlatoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlatoHandler implements IPlatoHandler {

    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;
    private final IPlatoResponseMapper platoResponseMapper;


    @Override
    public void savePlato(PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
        platoServicePort.savePlato(platoModel);
    }

    @Override
    public List<PlatoResponseDto> getAllPlatos() {
        return platoResponseMapper.toResponseList(platoServicePort.getAllPlatos());
    }

    @Override
    public PlatoResponseDto getPlatoById(Long id) {
        return platoResponseMapper.toResponsePlato(platoServicePort.getPlatoById(id));
    }

    @Override
    public void updatePlato(PlatoUpdateRequestDto platoUpdateRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoUpdateRequestDto);
        platoServicePort.updatePlato(platoModel);
    }

    @Override
    public void statusPlato(PlatoStatusRequestDto platoStatusRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoStatusRequestDto);
        platoServicePort.statusPlato(platoModel);
    }

    @Override
    public List<PlatoResponseDto> getAllPlatosRestaurant(Long restaurante, Integer page, Integer size) {
        return platoResponseMapper.toResponseList(platoServicePort.getAllPlatosRestaurant(restaurante,page,size));
    }
}