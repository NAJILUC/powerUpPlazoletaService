package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.PedidoEntity;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.PlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPedidoEntityMapper {

    @Mapping(target = "id_restaurante.id", source = "id_restaurante.id")
    PedidoEntity toPedidoEntity(PedidoModel pedidoModel);

    @Mapping(target = "id_restaurante.id", source = "id_restaurante.id")
    PedidoModel toPedidoModel(PedidoEntity pedidoEntity);

    List<PedidoModel> toPedidoModelList(List<PedidoEntity> pedidoEntityList);
}
