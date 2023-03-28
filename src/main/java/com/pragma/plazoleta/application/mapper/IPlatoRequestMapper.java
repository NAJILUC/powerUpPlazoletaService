package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoStatusRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoUpdateRequestDto;
import com.pragma.plazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoRequestMapper {

    @Mapping(target = "restaurante.id", source = "restaurante")
    @Mapping(target = "categoria.id", source = "categoria")
    PlatoModel toPlato(PlatoRequestDto platoRequestDto);

    PlatoModel toPlato(PlatoUpdateRequestDto platoUpdateRequestDto);
    PlatoModel toPlato(PlatoStatusRequestDto platoStatusRequestDto);
}
