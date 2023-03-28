package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.plazoleta.application.dto.request.Pedido_platoRequestDto;
import com.pragma.plazoleta.application.handler.IPedidoHandler;
import com.pragma.plazoleta.application.mapper.IPedidoRequestMapper;
import com.pragma.plazoleta.application.mapper.IPedido_platoRequestMapper;
import com.pragma.plazoleta.domain.api.IPedidoServicePort;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.spi.token.IToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoHandler implements IPedidoHandler {

    private final IPedidoServicePort pedidoServicePort;
    private final IPedidoRequestMapper pedidoRequestMapper;

    private final IToken iToken;

    private final IPedido_platoRequestMapper pedido_platoRequestMapper;

    @Override
    public void savePedido(PedidoRequestDto pedidoRequestDto) {
        Pedido_platoRequestDto aux = new Pedido_platoRequestDto();
        PedidoModel pedidoModel = pedidoRequestMapper.toPedido(pedidoRequestDto);
        pedidoModel.setCliente(iToken.getUserAuthenticatedId(iToken.getBearerToken()));
        List<Pedido_platoModel> pedido_platoModels = new ArrayList<>();

        for (Map<Long,Long> pedidosPlatos:pedidoRequestDto.getPlatoCantidad()) {
            aux.setId_pedido(pedidoModel.getId());
            aux.setId_plato(Long.parseLong(pedidosPlatos.keySet().toString().replace("[","").replace("]","")));
            aux.setCantidad(Long.parseLong(pedidosPlatos.values().toString().replace("[","").replace("]","")));
            pedido_platoModels.add(pedido_platoRequestMapper.toPedido_platoModel(aux));
        }
        pedidoServicePort.savePedido(pedidoModel,pedido_platoModels);
    }
}
