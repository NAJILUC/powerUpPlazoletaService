package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.Restaurante_empleadoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)

public interface IRestaurante_empleadoEntityMapper {

    Restaurante_empleadoEntity toEntity(Restaurante_empleadoModel restaurante_empleadoModel);

    Restaurante_empleadoModel toModel(Restaurante_empleadoEntity restaurante_empleadoEntity);

    List<Restaurante_empleadoModel> toRestaurante_empleadoModelList(List<Restaurante_empleadoEntity> restaurante_empleadoEntityList);
}
