package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.response.Restaurante_empleadoResponseDto;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurante_empleadoResponseMapper {

    Restaurante_empleadoResponseDto toResponseRestaurante_empleadoModel(Restaurante_empleadoModel restaurante_empleadoModel);

    Restaurante_empleadoModel toRestaurante_empleadoModel(Restaurante_empleadoResponseDto restaurante_empleadoResponseDto);

    List<Restaurante_empleadoResponseDto> toResponseList(List<Restaurante_empleadoModel> restaurante_empleadoModels);



}
