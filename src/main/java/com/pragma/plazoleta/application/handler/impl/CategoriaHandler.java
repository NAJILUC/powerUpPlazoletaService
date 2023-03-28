package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.request.CategoriaRequestDto;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.handler.ICategoriaHandler;
import com.pragma.plazoleta.application.mapper.ICategoriaRequestMapper;
import com.pragma.plazoleta.application.mapper.ICategoriaResponseMapper;
import com.pragma.plazoleta.domain.api.ICategoriaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaHandler implements ICategoriaHandler {

    private final ICategoriaServicePort categoriaServicePort;

    private final ICategoriaRequestMapper categoriaRequestMapper;

    private final ICategoriaResponseMapper categoriaResponseMapper;

    @Override
    public void saveCategoria(CategoriaRequestDto categoriaRequestDto) {
        categoriaServicePort.saveCategoria(categoriaRequestMapper.toCategoria(categoriaRequestDto));
    }

    @Override
    public List<CategoriaResponseDto> getAllCategorias() {
        return categoriaResponseMapper.toResponseList(categoriaServicePort.getAllCategorias());
    }

    @Override
    public CategoriaResponseDto getCategoriaById(Long id) {
        return categoriaResponseMapper.toResponseCategoria(categoriaServicePort.getCategoriaById(id));
    }
}
