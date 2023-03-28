package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRestauranteEntityMapper {

    RestauranteEntity toEntity(RestauranteModel user);
    RestauranteModel toRestauranteModel(RestauranteEntity restauranteEntity);
    List<RestauranteModel> toRestauranteModelList(List<RestauranteEntity> userEntityList);

}