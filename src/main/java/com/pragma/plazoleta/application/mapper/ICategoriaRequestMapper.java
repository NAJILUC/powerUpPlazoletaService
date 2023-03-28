package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.request.CategoriaRequestDto;
import com.pragma.plazoleta.domain.model.CategoriaModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoriaRequestMapper {

    CategoriaModel toCategoria(CategoriaRequestDto categoriaRequestDto);

    CategoriaRequestDto toRequest(CategoriaModel categoriaModel);
}
