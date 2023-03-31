package com.pragma.plazoleta.domain.spi.feignCLient;

import com.pragma.plazoleta.application.dto.request.MessageRequestDto;

public interface IMessageFeignClientPort {

    void proccesMessage(MessageRequestDto messageRequestDto);
}
