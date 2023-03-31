package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.PlatoRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoStatusRequestDto;
import com.pragma.plazoleta.application.dto.request.PlatoUpdateRequestDto;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.dto.response.PlatoResponseDto;
import com.pragma.plazoleta.application.handler.IPlatoHandler;
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
public class PlatoRestController {

    private final IPlatoHandler platoHandler;

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

    @Operation(summary = "Update a platos")
    @PostMapping("/updatePlato")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<Void> updatePlato(@RequestBody PlatoUpdateRequestDto platoUpdateRequestDto) {
        platoHandler.updatePlato(platoUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Set plato status")
    @PostMapping("/statusPlato")
    @PreAuthorize("hasAuthority('Propietario')")
    public ResponseEntity<Void> updateStatusPlato(@RequestBody PlatoStatusRequestDto platoStatusRequestDto) {
        platoHandler.statusPlato(platoStatusRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all platos of a restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All platos returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/getMenu/{restaurant}/{page}")
    @PreAuthorize("hasAuthority('Cliente')")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatosRestaurant(@PathVariable Long restaurant, @PathVariable int page ) {
        return ResponseEntity.ok(platoHandler.getAllPlatosRestaurant(restaurant,0, page));
    }

}
