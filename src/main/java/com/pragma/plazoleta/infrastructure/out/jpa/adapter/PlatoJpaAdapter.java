package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.IPlatoPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NoDataFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.PlatoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPlatoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;



    @Override
    public PlatoModel savePlato(PlatoModel platoModel) {
        PlatoEntity platoEntity = platoRepository.save(platoEntityMapper.toEntity(platoModel));
        return platoEntityMapper.toPlatoModel(platoEntity);
    }

    @Override
    public List<PlatoModel> getAllPlatos() {
        List<PlatoEntity> entityList = platoRepository.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
        if(entityList.isEmpty()) throw new NoDataFoundException();
        return platoEntityMapper.toPlatoModelList(entityList);
    }

    @Override
    public List<PlatoModel> getAllPlatosRestaurant(Integer page, Integer size) {

        List<PlatoEntity> entityList = new ArrayList<>();

        Page<PlatoEntity> entityPage = platoRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"categoria.nombre")));
        for (PlatoEntity plato: entityPage) {
            entityList.add(plato);
        }
        if(entityList.isEmpty()) throw new NoDataFoundException();
        return platoEntityMapper.toPlatoModelList(entityList);
    }

}