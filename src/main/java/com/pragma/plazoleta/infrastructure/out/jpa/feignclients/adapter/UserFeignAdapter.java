package com.pragma.plazoleta.infrastructure.out.jpa.feignclients.adapter;

import com.pragma.plazoleta.application.dto.response.UserResponseDto;
import com.pragma.plazoleta.domain.spi.feignCLient.IUserFeignClientPort;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeignAdapter implements IUserFeignClientPort {

    private final UserFeignClient userFeignClient;

    @Override
    public Boolean userExist(Long id) {
        return userFeignClient.userExist(id);
    }

    @Override
    public UserResponseDto getUserByEmail(String correo) {
        return userFeignClient.getUserByEmail(correo);
    }
}
