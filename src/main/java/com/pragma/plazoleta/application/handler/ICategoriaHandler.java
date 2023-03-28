package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.request.CategoriaRequestDto;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;

import java.util.List;

public interface ICategoriaHandler {

    void saveCategoria(CategoriaRequestDto categoriaRequestDto);

    List<CategoriaResponseDto> getAllCategorias();

    CategoriaResponseDto getCategoriaById(Long id);
}
