package com.pragma.plazoleta.infrastructure.out.jpa.feignclients.adapter;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;
import com.pragma.plazoleta.domain.spi.feignCLient.IMessageFeignClientPort;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.MessageFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
public class MessageFeignAdapter implements IMessageFeignClientPort {

    private final MessageFeignClient messageFeignClient;
    @Override
    public void proccesMessage(MessageRequestDto messageRequestDto) {
//        String celular = messageRequestDto.getCelular();
//        String mensaje = messageRequestDto.getMensaje();
        messageFeignClient.proccesMessage(messageRequestDto);
    }
}
