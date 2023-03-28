package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoResponseMapper {

    PlatoResponseDto toResponsePlato(PlatoModel platoModel);

    List<PlatoResponseDto> toResponseList(List<PlatoModel> platoModelList);
}
