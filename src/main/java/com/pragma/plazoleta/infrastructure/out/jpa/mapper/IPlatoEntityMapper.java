package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.PlatoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPlatoEntityMapper {

    @Mapping(target = "restaurante.id", source = "restaurante.id")
    @Mapping(target = "categoria.id", source = "categoria.id")
    PlatoEntity toEntity(PlatoModel plato);

    @Mapping(target = "restaurante.id", source = "restaurante.id")
    @Mapping(target = "categoria.id", source = "categoria.id")
    PlatoModel toPlatoModel(PlatoEntity platoEntity);

    List<PlatoModel> toPlatoModelList(List<PlatoEntity> platoEntityList);
}