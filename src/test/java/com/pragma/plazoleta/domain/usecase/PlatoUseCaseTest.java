package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.model.CategoriaModel;
import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.domain.model.RestauranteModel;
import com.pragma.plazoleta.domain.spi.IPlatoPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PlatoUseCaseTest {

    @InjectMocks
    PlatoUseCase platoUseCase;

    @Mock
    IPlatoPersistencePort platoPersistencePort;

    @Test
    void MustSavePlato() {
        //Given
        //Como propietario de un restaurante debo poder guardar un plato
        PlatoModel expectedPlato = new PlatoModel(1L,"Sancocho",new CategoriaModel(1L,"Comida tipica",
                "Comida tipica de los santanderes"),"Sopa Sancocho eche",10000L,new RestauranteModel(1L,"dsadas",
                "123456","Calle 5 # 5-54","1234567890","google,com",1L),"google.com",true);

        CategoriaModel categoriaModel = new CategoriaModel(1L,"Comida tipica","Comida tipica de los santanderes");

        RestauranteModel restauranteModel = new RestauranteModel(1L,"dsadas","123456",
                "Calle 5 # 5-54","1234567890","google.com",4L);

        PlatoModel platoModel = new PlatoModel(1L,"Sancocho", categoriaModel,"Sopa Sancocho eche",
                10000L,restauranteModel,"google.com",true);


        //When
        //Le envio los valores correctamente
        platoUseCase.savePlato(platoModel);


        //Then
        //El sistema guarda el usuario
        Mockito.verify(platoPersistencePort).savePlato(Mockito.any(PlatoModel.class));
        assertEquals(expectedPlato.getId(), platoModel.getId());
        assertEquals(expectedPlato.getDescripcion(), platoModel.getDescripcion());
        assertEquals(expectedPlato.getNombre(), platoModel.getNombre());
        assertEquals(expectedPlato.getPrecio(), platoModel.getPrecio());
        assertEquals(expectedPlato.getActivo(), platoModel.getActivo());
        assertEquals(expectedPlato.getRestaurante().getId(), platoModel.getRestaurante().getId());
        assertEquals(expectedPlato.getCategoria().getId(), platoModel.getCategoria().getId());
        assertEquals(expectedPlato.getUrlLogo(), platoModel.getUrlLogo());
    }

    @Test
    void MustUpdatePlato() {
        //Given
        //Como propietario de un restaurante debo poder actualizar un plato
        PlatoModel expectedPlato = new PlatoModel(1L,"Sancocho",new CategoriaModel(1L,"Comida tipica",
                "Comida tipica de los santanderes"),"Sopa Sancocho eche",10000L,new RestauranteModel(1L,"dsadas",
                "123456","Calle 5 # 5-54","1234567890","google,com",1L),"google.com",true);


        CategoriaModel categoriaModel = new CategoriaModel(1L,"Comida tipica","Comida tipica de los santanderes");

        RestauranteModel restauranteModel = new RestauranteModel(1L,"dsadas","123456",
                "Calle 5 # 5-54","1234567890","google.com",4L);

        PlatoModel platoModel = new PlatoModel(1L,null, categoriaModel,"Sopa Sancocho eche",
                10000L,restauranteModel,"google.com",true);

        //When
        //Le envio los valores correctamente
        platoUseCase.updatePlato(platoModel);

        //Then
        //El sistema actualiza el usuario
        assertEquals(expectedPlato.getId(), platoModel.getId());
        assertEquals(expectedPlato.getDescripcion(), platoModel.getDescripcion());
        assertEquals(expectedPlato.getNombre(), platoModel.getNombre());
        assertEquals(expectedPlato.getPrecio(), platoModel.getPrecio());
        assertEquals(expectedPlato.getActivo(), platoModel.getActivo());
        assertEquals(expectedPlato.getRestaurante().getId(), platoModel.getRestaurante().getId());
        assertEquals(expectedPlato.getCategoria().getId(), platoModel.getCategoria().getId());
        assertEquals(expectedPlato.getUrlLogo(), platoModel.getUrlLogo());

    }

    @Test
    void MustSetStatusPlato() {
        //Given
        //Como propietario de un restaurante debo poder cambiar el estado de un plato
        PlatoModel expectedPlato = new PlatoModel(1L,"Sancocho",new CategoriaModel(1L,"Comida tipica",
                "Comida tipica de los santanderes"),"Sopa Sancocho eche",10000L,new RestauranteModel(1L,"dsadas",
                "123456","Calle 5 # 5-54","1234567890","google,com",1L),"google.com",false);


        CategoriaModel categoriaModel = new CategoriaModel(1L,"Comida tipica","Comida tipica de los santanderes");

        RestauranteModel restauranteModel = new RestauranteModel(1L,"dsadas","123456",
                "Calle 5 # 5-54","1234567890","google.com",4L);

        PlatoModel platoModel = new PlatoModel(1L,"Sancocho", categoriaModel,"Sopa Sancocho eche",
                10000L,restauranteModel,"google.com",false);

        //When
        //Le envio los valores correctamente
        platoUseCase.statusPlato(platoModel);

        //Then
        //El sistema actualiza el usuario
        Mockito.verify(platoPersistencePort).savePlato(Mockito.any(PlatoModel.class));
        assertEquals(expectedPlato.getId(), platoModel.getId());
        assertEquals(expectedPlato.getDescripcion(), platoModel.getDescripcion());
        assertEquals(expectedPlato.getNombre(), platoModel.getNombre());
        assertEquals(expectedPlato.getPrecio(), platoModel.getPrecio());
        assertEquals(expectedPlato.getActivo(), platoModel.getActivo());
        assertEquals(expectedPlato.getRestaurante().getId(), platoModel.getRestaurante().getId());
        assertEquals(expectedPlato.getCategoria().getId(), platoModel.getCategoria().getId());
        assertEquals(expectedPlato.getUrlLogo(), platoModel.getUrlLogo());
    }
}