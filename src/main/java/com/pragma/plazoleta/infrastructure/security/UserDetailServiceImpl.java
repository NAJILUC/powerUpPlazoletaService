package com.pragma.plazoleta.infrastructure.security;

import com.pragma.plazoleta.application.dto.response.UserResponseDto;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        UserResponseDto userResponseDto = userFeignClient.getUserByEmail(correo);
        return new UserDetailsImpl(userResponseDto);
    }
}
