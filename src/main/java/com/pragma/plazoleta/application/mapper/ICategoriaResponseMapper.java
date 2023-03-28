package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.domain.model.CategoriaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoriaResponseMapper {

    CategoriaResponseDto toResponseCategoria(CategoriaModel categoriaModel);

    List<CategoriaResponseDto> toResponseList(List<CategoriaModel> categoriaModelList);
}
