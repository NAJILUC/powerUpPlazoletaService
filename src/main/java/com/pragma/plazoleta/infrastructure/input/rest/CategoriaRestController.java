package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.request.CategoriaRequestDto;
import com.pragma.plazoleta.application.dto.response.CategoriaResponseDto;
import com.pragma.plazoleta.application.handler.ICategoriaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurante")
@RequiredArgsConstructor
public class CategoriaRestController {

    private final ICategoriaHandler categoriaHandler;

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

}
