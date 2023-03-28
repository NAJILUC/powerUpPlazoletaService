package com.pragma.plazoleta.domain.spi.feignCLient;


import com.pragma.plazoleta.application.dto.response.UserResponseDto;

public interface IUserFeignClientPort {

    Boolean userExist( Long id);
    UserResponseDto getUserByEmail(String correo);
}
