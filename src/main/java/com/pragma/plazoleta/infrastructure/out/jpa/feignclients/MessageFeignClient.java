package com.pragma.plazoleta.infrastructure.out.jpa.feignclients;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "message-service", url = "localhost:8085")
public interface MessageFeignClient {

    @PostMapping("/api/v1/message/")
    public ResponseEntity<Void> proccesMessage(@RequestBody MessageRequestDto messageRequestDto);
}
