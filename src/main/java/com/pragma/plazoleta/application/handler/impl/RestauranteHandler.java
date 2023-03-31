package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.request.RestauranteRequestDto;
import com.pragma.plazoleta.application.dto.response.RestauranteResponseDto;
import com.pragma.plazoleta.application.dto.response.UserResponseDto;
import com.pragma.plazoleta.application.handler.IRestauranteHandler;
import com.pragma.plazoleta.application.mapper.IRestauranteRequestMapper;
import com.pragma.plazoleta.application.mapper.IRestauranteResponseMapper;
import com.pragma.plazoleta.domain.api.IRestauranteServicePort;
import com.pragma.plazoleta.domain.exception.DomainException;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.token.IToken;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestauranteHandler implements IRestauranteHandler {

    private final IRestauranteServicePort restauranteServicePort;
    private final IRestauranteRequestMapper restauranteRequestMapper;
    private final IRestauranteResponseMapper restauranteResponseMapper;

    private final IToken iToken;
    private final UserFeignClient userFeignClient;

    @Override
    public void saveRestaurante(RestauranteRequestDto restauranteRequestDto) {
//        System.out.println(iToken.getUserAuthenticatedId(iToken.getBearerToken()));
      if(userFeignClient.userExist(restauranteRequestDto.getIdPropietario())) {
            RestauranteModel restauranteModel = restauranteRequestMapper.toObject(restauranteRequestDto);
//          System.out.println("El restaurante "+restauranteModel.getNombre()+" se guardo");
            restauranteServicePort.saveRestaurante(restauranteModel);
        }else throw new DomainException("El usuario no existe o no tiene el rol propietario");
       /* List<UserResponseDto> users = userFeignClient.getAllUsers();
        for (UserResponseDto user: users) {
            System.out.println(user.getId() +" "+ user.getNombre() +" "+ user.getApellido() +" "+ user.getRol().getNombreRol() +" "+ user.getCorreo());
        }*/
    }

    @Override
    public List<RestauranteResponseDto> getAllRestaurantes(Integer page, Integer size) {
        return restauranteResponseMapper.toResponseList(restauranteServicePort.getAllRestaurantes(page,size));
    }

}