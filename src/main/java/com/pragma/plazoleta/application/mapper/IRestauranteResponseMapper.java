package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteResponseMapper {
    RestauranteResponseDto toResponse(RestauranteModel restauranteModel);

    List<RestauranteResponseDto> toResponseList(List<RestauranteModel> restauranteModelList);
}
