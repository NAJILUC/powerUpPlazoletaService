package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteRequestMapper {
    RestauranteModel toObject(RestauranteRequestDto restauranteRequestDto);
}
