package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.application.dto.request.PedidoRequestDto;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.plazoleta.application.handler.IPedidoHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurante")
@RequiredArgsConstructor
public class PedidoRestController {

    private final IPedidoHandler pedidoHandler;

    @Operation(summary = "Add a new Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Order already exists", content = @Content)
    })
    @PostMapping("/pedido")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<Void> savePedido(@RequestBody PedidoRequestDto pedidoRequestDto) {
        pedidoHandler.savePedido(pedidoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All orders returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/getPedidos/{page}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos(@PathVariable int page ) {
        return ResponseEntity.ok(pedidoHandler.getAllPpedidos(0, page));
    }

    @Operation(summary = "Assign a Employed")
    @PostMapping("/assignEmployed/{idPedido}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<Void> assignEmployed(@PathVariable("idPedido") Long idPedido){
        pedidoHandler.assignEmployed(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Notify a Order")
    @PostMapping("/notifyOrder/{idCliente}")
    public ResponseEntity<Void> notifyOrder(@PathVariable("idCliente") Long idCliente,@RequestBody MessageRequestDto messageRequestDto){
        pedidoHandler.proccesMessage(messageRequestDto, idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delivery a Order")
    @PostMapping("/deliverOrder/{idPedido}/{pin}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<Void> deliverOrder(@PathVariable("idPedido") Long idPedido,@PathVariable("pin") Long pin){
        pedidoHandler.deliverOrder(idPedido, pin);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Cancel a Order")
    @PostMapping("/cancelOrder/{idPedido}")
    public ResponseEntity<Void> cancelOrder(@PathVariable("idPedido")Long idPedido){
        pedidoHandler.cancelOrder(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
