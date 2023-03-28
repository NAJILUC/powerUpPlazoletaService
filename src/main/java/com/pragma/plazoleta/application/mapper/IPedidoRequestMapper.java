package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.plazoleta.domain.model.PedidoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoRequestMapper {

    @Mapping(target = "id_restaurante.id", source = "idRestaurante")
    PedidoModel toPedido(PedidoRequestDto pedidoRequestDto);


}
