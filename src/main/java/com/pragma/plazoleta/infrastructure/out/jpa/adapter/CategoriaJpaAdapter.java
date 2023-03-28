package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.ICategoriaPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NoDataFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.CategoriaEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.ICategoriaRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoriaJpaAdapter implements ICategoriaPersistencePort {

    private final ICategoriaRepository categoriaRepository;
    private final ICategoriaEntityMapper categoriaEntityMapper;


    @Override
    public CategoriaModel saveCategoria(CategoriaModel categoriaModel) {
        CategoriaEntity categoriaEntity = categoriaRepository.save(categoriaEntityMapper.toEntity(categoriaModel));
        return categoriaEntityMapper.toCategproaModel(categoriaEntityMapper.toEntity(categoriaModel));
    }

    @Override
    public List<CategoriaModel> getAllCategorias() {

        List<CategoriaEntity> entityList = categoriaRepository.findAll();
        if(entityList.isEmpty())throw new NoDataFoundException();
        return categoriaEntityMapper.toCategoriaModelList(entityList);
    }

    @Override
    public CategoriaModel getCategoriaById(Long id) {
        Optional<CategoriaEntity> optionalCategoriaEntity = categoriaRepository.findById(id);
        CategoriaEntity categoriaEntity = optionalCategoriaEntity.orElse(null);
        return categoriaEntityMapper.toCategproaModel(categoriaEntity);
    }
}