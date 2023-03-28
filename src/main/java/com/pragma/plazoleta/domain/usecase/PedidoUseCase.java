package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IPedidoServicePort;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedido_platoPersistencePort;

import java.util.Date;
import java.util.List;

public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistencePort pedidoPersistencePort;
    private final IPedido_platoPersistencePort pedido_platoPersistencePort;

    public PedidoUseCase(IPedidoPersistencePort pedidoPersistencePort, IPedido_platoPersistencePort pedido_platoPersistencePort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.pedido_platoPersistencePort = pedido_platoPersistencePort;
    }


    @Override
    public void savePedido(PedidoModel pedidoModel, List<Pedido_platoModel> pedido_platoModels) {
        pedidoModel.setEstado("Pendiente");
        pedidoModel.setFecha(new Date());
        pedidoModel.setId_chef(new Restaurante_empleadoModel(0L,1L));

        List<PedidoModel> pedidos = getAllPedidos();

        for (PedidoModel pedido: pedidos) {
            if(pedido.getCliente()==pedidoModel.getCliente()){
                if(pedido.getEstado().equalsIgnoreCase("Pendiente")||
                        pedido.getEstado().equalsIgnoreCase("en_preparacion")||
                        pedido.getEstado().equalsIgnoreCase("Listo")) {
            //        System.out.println("no puede");
                    return;
                }
            }
        }

        //Hasta aca guarda en la tabla pedido

        pedidoPersistencePort.savePedido(pedidoModel);

        pedidos = getAllPedidos();
        Pedido_platoModel pedido_platoModel = new Pedido_platoModel();

        for (PedidoModel pedido: pedidos) {
            if(pedido.getCliente()==pedidoModel.getCliente()&&pedidoModel.getEstado().equalsIgnoreCase(pedido.getEstado())
                &&pedidoModel.getId_restaurante().getId()==pedido.getId_restaurante().getId()&&pedidoModel.getFecha()==pedido.getFecha()){
                pedido_platoModel.setId_pedido(pedido);
                System.out.println(pedido_platoModel.getId_pedido().getId());
                for (Pedido_platoModel platosPedidos:pedido_platoModels) {
                    pedido_platoModel.setId_plato(platosPedidos.getId_plato());
                    pedido_platoModel.setCantidad(platosPedidos.getCantidad());
                    pedido_platoPersistencePort.savePedido_plato(pedido_platoModel);
                }
                return;
            }
        }
       // System.out.println("stpop");
      //  pedidoPersistencePort.savePedido(pedidoModel);
    }

    @Override
    public List<PedidoModel> getAllPedidos() {
        return pedidoPersistencePort.getAllPedidos();
    }
}
