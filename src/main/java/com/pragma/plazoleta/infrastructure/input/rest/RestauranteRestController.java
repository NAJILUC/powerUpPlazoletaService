package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.*;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.dto.response.PedidoResponseDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.plazoleta.application.handler.ICategoriaHandler;
import com.pragma.plazoleta.application.handler.IPedidoHandler;
import com.pragma.plazoleta.application.handler.IPlatoHandler;
import com.pragma.plazoleta.application.handler.IRestauranteHandler;
import com.pragma.plazoleta.application.handler.IRestaurante_empleadoHandler;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/restaurante")
@RequiredArgsConstructor
public class RestauranteRestController {

    private final IRestauranteHandler restauranteHandler;
    private final ICategoriaHandler categoriaHandler;
    private final IPlatoHandler platoHandler;
    private final IPedidoHandler pedidoHandler;
    private final IRestaurante_empleadoHandler restaurante_empleadoHandler;


    @Operation(summary = "Add a new restaurante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/")
    @PreAuthorize("hasAuthority('Administrador')")
    public ResponseEntity<Void> saveRestaurante(@RequestBody RestauranteRequestDto restauranteRequestDto) {
        restauranteHandler.saveRestaurante(restauranteRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Restaurantes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Restaurantes returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestauranteResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/{page}")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<List<RestauranteResponseDto>> getAllRestaurantes(@PathVariable int page) {
        return ResponseEntity.ok(restauranteHandler.getAllRestaurantes(0,page));
    }

    /*

        CATEGORIAS

     */

    @Operation(summary = "Add a new categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Categoria already exists", content = @Content)
    })
    @PostMapping("/categoria")
    public ResponseEntity<Void> saveCategoria(@RequestBody CategoriaRequestDto categoriaRequestDto) {
        categoriaHandler.saveCategoria(categoriaRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categorias returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaResponseDto>> getAllCategorias() {
        return ResponseEntity.ok(categoriaHandler.getAllCategorias());
    }

    /*

        PLATOS

     */

    @Operation(summary = "Add a new plato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plato created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Plato already exists", content = @Content)
    })
    @PostMapping("/plato")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<Void> savePlato(@RequestBody PlatoRequestDto platoRequestDto) {
        platoHandler.savePlato(platoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all platos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All platos returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/plato")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatos() {
        return ResponseEntity.ok(platoHandler.getAllPlatos());
    }

    @PostMapping("/updatePlato")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<Void> updatePlato(@RequestBody PlatoUpdateRequestDto platoUpdateRequestDto) {
        platoHandler.updatePlato(platoUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/statusPlato")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<Void> updateStatusPlato(@RequestBody PlatoStatusRequestDto platoStatusRequestDto) {
        platoHandler.statusPlato(platoStatusRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getMenu/{restaurant}/{page}")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatosRestaurant(@PathVariable Long restaurant,@PathVariable int page ) {
        return ResponseEntity.ok(platoHandler.getAllPlatosRestaurant(restaurant,0, page));
    }

    /*

        PEDIDOS

     */
    @PostMapping("/pedido")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<Void> savePedido(@RequestBody PedidoRequestDto pedidoRequestDto) {
         pedidoHandler.savePedido(pedidoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getPedidos/{page}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos(@PathVariable int page ) {
        return ResponseEntity.ok(pedidoHandler.getAllPpedidos(0, page));
    }

    @PostMapping("/assignEmployed/{idPedido}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<Void> assignEmployed(@PathVariable("idPedido") Long idPedido){
        pedidoHandler.assignEmployed(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/notifyOrder/{idCliente}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<Void> notifyOrder(@PathVariable("idCliente") Long idCliente,@RequestBody MessageRequestDto messageRequestDto){
        pedidoHandler.proccesMessage(messageRequestDto, idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deliverOrder/{idPedido}/{pin}")
    @PreAuthorize("hasAuthority('Empleado')")
    public ResponseEntity<Void> deliverOrder(@PathVariable("idPedido") Long idPedido,@PathVariable("pin") Long pin){
        pedidoHandler.deliverOrder(idPedido, pin);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/cancelOrder/{idPedido}")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<Void> cancelOrder(@PathVariable("idPedido")Long idPedido){
        pedidoHandler.cancelOrder(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*

        RESTAURANTE X EMPLEADO

     */
    @PostMapping("/restemp/{idPropietario}/{idEmpleado}")
    public ResponseEntity<Void> saveRestaurante_Empleado(@PathVariable("idPropietario") Long idPropietario,@PathVariable("idEmpleado") Long idEmpleado){

        restaurante_empleadoHandler.saveRestaurante_Empleado(idPropietario,idEmpleado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }








}