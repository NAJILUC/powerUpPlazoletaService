package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NoDataFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RestauranteJpaAdapter implements IRestaurantePersistencePort {

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;



    @Override
    public RestauranteModel saveRestaurante(RestauranteModel restauranteModel) {
        RestauranteEntity restauranteEntity = restauranteRepository.save(restauranteEntityMapper.toEntity(restauranteModel));
        return restauranteEntityMapper.toRestauranteModel(restauranteEntity);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes(Integer page, Integer size) {

        List<RestauranteEntity> entityList=new ArrayList<>();
        Page<RestauranteEntity> entityPage = restauranteRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"nombre")));
        for (RestauranteEntity res:entityPage) {
            entityList.add(res);
        }
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restauranteEntityMapper.toRestauranteModelList(entityList);
    }
}