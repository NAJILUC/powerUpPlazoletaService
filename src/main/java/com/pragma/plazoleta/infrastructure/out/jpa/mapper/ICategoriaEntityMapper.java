package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.CategoriaEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICategoriaEntityMapper {

    CategoriaEntity toEntity(CategoriaModel categoria);
    CategoriaModel toCategproaModel(CategoriaEntity categoriaEntity);
    List<CategoriaModel> toCategoriaModelList(List<CategoriaEntity> categoriaEntityList);
}