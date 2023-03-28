package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.CategoriaModel;

import java.util.List;

public interface ICategoriaServicePort {

    void saveCategoria(CategoriaModel categoriaModel);

    List<CategoriaModel> getAllCategorias();

    CategoriaModel getCategoriaById(Long id);
}