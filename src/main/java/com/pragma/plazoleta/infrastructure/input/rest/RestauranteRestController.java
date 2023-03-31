package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.*;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
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
    @Operation(summary = "Add a new Restaurant_Employed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant_Employed created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant_Employed already exists", content = @Content)
    })
    @PostMapping("/restemp/{idPropietario}/{idEmpleado}")
    public ResponseEntity<Void> saveRestaurante_Empleado(@PathVariable("idPropietario") Long idPropietario,@PathVariable("idEmpleado") Long idEmpleado){

        restaurante_empleadoHandler.saveRestaurante_Empleado(idPropietario,idEmpleado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}