package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.request.Pedido_platoRequestDto;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedido_platoRequestMapper {

    @Mapping(target = "id_plato.id", source = "id_plato")
    @Mapping(target = "id_pedido.id", source = "id_pedido")
    Pedido_platoModel toPedido_platoModel(Pedido_platoRequestDto pedido_platoRequestDto);
}
