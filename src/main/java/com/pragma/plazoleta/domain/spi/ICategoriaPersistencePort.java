package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.CategoriaModel;

import java.util.List;

public interface ICategoriaPersistencePort {

    CategoriaModel saveCategoria(CategoriaModel categoriaModel);

    List<CategoriaModel> getAllCategorias();

    CategoriaModel getCategoriaById(Long id);
}