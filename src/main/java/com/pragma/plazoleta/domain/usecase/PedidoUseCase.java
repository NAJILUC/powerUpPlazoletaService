package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.domain.api.IPedidoServicePort;
import com.pragma.plazoleta.domain.model.PedidoModel;
import com.pragma.plazoleta.domain.model.Pedido_platoModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedido_platoPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurante_empleadoPersistencePort;
import com.pragma.plazoleta.domain.spi.feignCLient.IMessageFeignClientPort;
import com.pragma.plazoleta.domain.spi.feignCLient.IUserFeignClientPort;
import com.pragma.plazoleta.domain.spi.token.IToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistencePort pedidoPersistencePort;
    private final IPedido_platoPersistencePort pedido_platoPersistencePort;
    private final IRestaurante_empleadoPersistencePort restaurante_empleadoPersistencePort;
    private final IToken iToken;
    private final IMessageFeignClientPort messageFeignClientPort;
    private final IUserFeignClientPort userFeignClientPort;

    public PedidoUseCase(IPedidoPersistencePort pedidoPersistencePort, IPedido_platoPersistencePort pedido_platoPersistencePort, IRestaurante_empleadoPersistencePort restaurante_empleadoPersistencePort, IToken iToken, IMessageFeignClientPort messageFeignClientPort, IUserFeignClientPort userFeignClientPort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.pedido_platoPersistencePort = pedido_platoPersistencePort;
        this.restaurante_empleadoPersistencePort = restaurante_empleadoPersistencePort;
        this.iToken = iToken;
        this.messageFeignClientPort = messageFeignClientPort;
        this.userFeignClientPort = userFeignClientPort;
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
                    //System.out.println("no puede");
                    return;
                }
            }
        }
        System.out.println(pedidoModel.getId()+" "+ pedidoModel.getCliente()+" "+ pedidoModel.getEstado());

        pedidoPersistencePort.savePedido(pedidoModel);
        //Hasta aca guarda en la tabla pedido


        pedidos = getAllPedidos();
        Pedido_platoModel pedido_platoModel = new Pedido_platoModel();

        for (PedidoModel pedido: pedidos) {
            if(pedido.getCliente()==pedidoModel.getCliente()&&pedidoModel.getEstado().equalsIgnoreCase(pedido.getEstado())
                &&pedidoModel.getId_restaurante().getId()==pedido.getId_restaurante().getId()&&pedidoModel.getFecha()==pedido.getFecha()){
                pedido_platoModel.setId_pedido(pedido);
                for (Pedido_platoModel platosPedidos:pedido_platoModels) {
                    pedido_platoModel.setId_plato(platosPedidos.getId_plato());
                    pedido_platoModel.setCantidad(platosPedidos.getCantidad());
                    pedido_platoPersistencePort.savePedido_plato(pedido_platoModel);
                }
                return;
            }
        }
       // System.out.println("stpop");
        //pedidoPersistencePort.savePedido(pedidoModel);
    }

    @Override
    public List<PedidoModel> getAllPedidos() {
        return pedidoPersistencePort.getAllPedidos();
    }
    @Override
    public List<PedidoModel> getAllPedidos(Integer page, Integer size) {
      //  List<PedidoModel> allPedidos = pedidoPersistencePort.getAllPedidos(page,size);
        List<PedidoModel> pedidos =pedidoPersistencePort.getAllPedidos(page,size);
        List<Restaurante_empleadoModel> empledosRes=restaurante_empleadoPersistencePort.getAllRestaurante_empleados();
        Long idRestaurante = 0L;
        for (Restaurante_empleadoModel restauranteEmpleados:empledosRes) {
            if(restauranteEmpleados.getId_persona()==iToken.getUserAuthenticatedId(iToken.getBearerToken()))idRestaurante=restauranteEmpleados.getId_restaurante();
        }
        List<PedidoModel> pedidosAM=new ArrayList<>();
        for (PedidoModel pedido:pedidos) {
            if(pedido.getId_restaurante().getId()==idRestaurante) {
                pedidosAM.add(pedido);
            }
        }
        return pedidosAM;
    }

    @Override
    public void proccesMessage(MessageRequestDto messageRequestDto, Long idCliente) {
        //if(!messageRequestDto.getCelular().contains("+57")) messageRequestDto.setCelular("+57".concat(messageRequestDto.getCelular()));
        messageRequestDto.setCelular("+573185746453");
        List<PedidoModel> pedidos = getAllPedidos();
        String pin = "";
        for (PedidoModel pedido:pedidos) {
            if(pedido.getCliente()==idCliente){
                pin = pedido.getId_restaurante().getId().toString().concat(pedido.getCliente().toString()).concat(pedido.getId().toString());
                messageRequestDto.setMensaje(pin);
                messageFeignClientPort.proccesMessage(messageRequestDto);
                return;
            }
        }
        messageFeignClientPort.proccesMessage(messageRequestDto);
    }

    public PedidoModel getPedidoById(Long id){
        List<PedidoModel> pedidos = getAllPedidos();
        PedidoModel pedidoN;
        for (PedidoModel pedido:pedidos) {
            if(pedido.getId()==id) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public void assignEmployed(Long idPedido) {
        PedidoModel pedido = getPedidoById(idPedido);
        List<PedidoModel> pedidos = getAllPedidos();
        Long idRestaurante =0L;
        List <Restaurante_empleadoModel> restaurante_empleadoModels = restaurante_empleadoPersistencePort.getAllRestaurante_empleados();
        for (Restaurante_empleadoModel restaurante_empleadoModel: restaurante_empleadoModels) {
            if(restaurante_empleadoModel.getId_persona()==iToken.getUserAuthenticatedId(iToken.getBearerToken()))idRestaurante=restaurante_empleadoModel.getId_restaurante();
        }
        for (PedidoModel pedidoModel: pedidos) {
            if(pedido.getId_restaurante().getId()==idRestaurante){
                pedido.setEstado("en_preparacion");
                pedido.getId_chef().setId_persona(iToken.getUserAuthenticatedId(iToken.getBearerToken()));
                pedidoPersistencePort.savePedido(pedido);
                return;
            }
        }
    }

    @Override
    public void deliverOrder(Long idPedido, Long pin) {
        PedidoModel pedido = getPedidoById(idPedido);
        if(!pedido.getEstado().equalsIgnoreCase("LIsTo"))return;
        String pinA = pedido.getId_restaurante().getId().toString().concat(pedido.getCliente().toString()).concat(pedido.getId().toString());
        if(pinA.equals(pin.toString())){
            pedido.setEstado("entregado");
            pedidoPersistencePort.savePedido(pedido);
        }
    }

    @Override
    public void cancelOrder(Long idPedido) {
        PedidoModel pedido = getPedidoById(idPedido);
        if(pedido.getCliente()!=iToken.getUserAuthenticatedId(iToken.getBearerToken()))return;
        if(pedido.getEstado().equalsIgnoreCase("Pendiente")){
            pedido.setEstado("Cancelado");
            pedidoPersistencePort.savePedido(pedido);
        }else {
            MessageRequestDto messageRequestDto = new MessageRequestDto();
            messageRequestDto.setCelular("+573185746453");
            messageRequestDto.setMensaje("Lo sentimos, tu pedido ya esta en preparacion y no puede cancelarse");
            messageFeignClientPort.proccesMessage(messageRequestDto);
        }

    }
}
