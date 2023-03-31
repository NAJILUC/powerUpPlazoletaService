package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoResponseMapper {

    PedidoResponseDto toResponsePedido(PedidoModel pedidoModel);

    List<PedidoResponseDto> toResponseList(List<PedidoModel> pedidoModelList);
}
