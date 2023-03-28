package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.Pedido_platoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPedido_platoEntityMapper {

    Pedido_platoEntity toPedido_platoEntity(Pedido_platoModel pedido_platoModel);

    Pedido_platoModel toPedido_platoModel(Pedido_platoEntity pedido_platoEntity);

    List<Pedido_platoModel> toPedido_platoModelList(List<Pedido_platoEntity> pedido_platoEntityList);
}
