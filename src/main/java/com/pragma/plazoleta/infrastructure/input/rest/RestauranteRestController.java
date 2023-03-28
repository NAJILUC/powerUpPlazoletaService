package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.*;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.plazoleta.application.handler.ICategoriaHandler;
import com.pragma.plazoleta.application.handler.IPedidoHandler;
import com.pragma.plazoleta.application.handler.IPlatoHandler;
import com.pragma.plazoleta.application.handler.IRestauranteHandler;
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
import java.util.Map;

@RestController
@RequestMapping("/api/v1/restaurante")
@RequiredArgsConstructor
public class RestauranteRestController {

    private final IRestauranteHandler restauranteHandler;
    private final ICategoriaHandler categoriaHandler;
    private final IPlatoHandler platoHandler;
    private final IPedidoHandler pedidoHandler;


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
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatos() {
        return ResponseEntity.ok(platoHandler.getAllPlatos());
    }

    @PostMapping("/updatePlato")
    public ResponseEntity<Void> updatePlato(@RequestBody PlatoUpdateRequestDto platoUpdateRequestDto) {
        platoHandler.updatePlato(platoUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/statusPlato")
    public ResponseEntity<Void> updateStatusPlato(@RequestBody PlatoStatusRequestDto platoStatusRequestDto) {
        platoHandler.statusPlato(platoStatusRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getMenu/{restaurant}/{page}")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatosRestaurant(@PathVariable Long restaurant,@PathVariable int page ) {
        return ResponseEntity.ok(platoHandler.getAllPlatosRestaurant(restaurant,0, page));
    }

    /*

        PEDIDOS

     */
    @PostMapping("/pedido")
    public ResponseEntity<Void> prubaListar(@RequestBody PedidoRequestDto pedidoRequestDto) {
        System.out.println(pedidoRequestDto.getIdRestaurante());
        for (Map<Long,Long> aux: pedidoRequestDto.getPlatoCantidad()) {

            System.out.println(aux.keySet()+" "+aux.values());
        }
         pedidoHandler.savePedido(pedidoRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}