package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RestauranteUseCaseTest {

    @InjectMocks
    RestauranteUseCase restauranteUseCase;

    @Mock
    IRestaurantePersistencePort restaurantePersistencePort;

    @Test
    void saveRestaurante() {
        //Given
        //Como usuario administrador debo guardar un restaurante siempre y cuando el propietario exista
        RestauranteModel expectedRestaurante = new RestauranteModel(1L,"dsadas","123456",
                "Calle 5 # 5-54","1234567890","google.com",4L);

        RestauranteModel restauranteModel = new RestauranteModel(1L,"dsadas","123456",
                "Calle 5 # 5-54","1234567890","google.com",4L);

        //When
        //Envio los valores correctamente
        restauranteUseCase.saveRestaurante(restauranteModel);

        //Then
        //El sistema guarda el restaurante
        Mockito.verify(restaurantePersistencePort).saveRestaurante(Mockito.any(RestauranteModel.class));
    }
}