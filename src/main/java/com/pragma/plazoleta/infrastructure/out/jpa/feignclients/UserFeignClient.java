package com.pragma.plazoleta.infrastructure.out.jpa.feignclients;

import com.pragma.plazoleta.application.dto.response.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient(name = "user-service", url = "localhost:8081")
public interface UserFeignClient {

    @PostMapping("/api/v1/user/userOwnerExist/{id}")
    Boolean userExist(@PathVariable("id") Long id);

    @GetMapping("/api/v1/user/")
    List<UserResponseDto> getAllUsers();

    @PostMapping("/getUserEmail/{correo}")
    UserResponseDto getUserByEmail(@PathVariable("correo") String correo);

}
