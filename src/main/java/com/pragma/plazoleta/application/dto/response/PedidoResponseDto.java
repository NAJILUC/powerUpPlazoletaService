package com.pragma.plazoleta.application.dto.response;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PedidoResponseDto {

    private Long id;
    private Long cliente;
    private Date fecha;
    private String estado;
    private Restaurante_empleadoModel id_chef;
    private RestauranteModel id_restaurante;
}
