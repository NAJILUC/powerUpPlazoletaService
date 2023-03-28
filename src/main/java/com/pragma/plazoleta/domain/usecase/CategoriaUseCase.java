package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.ICategoriaServicePort;
import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.spi.ICategoriaPersistencePort;

import java.util.List;

public class CategoriaUseCase implements ICategoriaServicePort {

    private final ICategoriaPersistencePort categoriaPersistencePort;

    public CategoriaUseCase(ICategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public void saveCategoria(CategoriaModel categoriaModel) {
        categoriaPersistencePort.saveCategoria(categoriaModel);
    }

    @Override
    public List<CategoriaModel> getAllCategorias() {
        return categoriaPersistencePort.getAllCategorias();
    }

    @Override
    public CategoriaModel getCategoriaById(Long id){
        return categoriaPersistencePort.getCategoriaById(id);
    }
}