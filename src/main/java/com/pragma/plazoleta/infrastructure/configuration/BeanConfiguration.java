package com.pragma.plazoleta.infrastructure.configuration;

import com.pragma.plazoleta.domain.api.ICategoriaServicePort;
import com.pragma.plazoleta.domain.api.IPedidoServicePort;
import com.pragma.plazoleta.domain.api.IPlatoServicePort;
import com.pragma.plazoleta.domain.api.IRestauranteServicePort;
import com.pragma.plazoleta.domain.spi.ICategoriaPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedidoPersistencePort;
import com.pragma.plazoleta.domain.spi.IPedido_platoPersistencePort;
import com.pragma.plazoleta.domain.spi.IPlatoPersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurantePersistencePort;
import com.pragma.plazoleta.domain.spi.IRestaurante_empleadoPersistencePort;
import com.pragma.plazoleta.domain.spi.feignCLient.IUserFeignClientPort;
import com.pragma.plazoleta.domain.spi.token.IToken;
import com.pragma.plazoleta.domain.usecase.CategoriaUseCase;
import com.pragma.plazoleta.domain.usecase.PedidoUseCase;
import com.pragma.plazoleta.domain.usecase.PlatoUseCase;
import com.pragma.plazoleta.domain.usecase.RestauranteUseCase;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.CategoriaJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.PedidoJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.Pedido_platoJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.PlatoJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.RestauranteJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.adapter.Restaurante_empleadoJpaAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.UserFeignClient;
import com.pragma.plazoleta.infrastructure.out.jpa.feignclients.adapter.UserFeignAdapter;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPedidoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPedido_platoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.ICategoriaRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedidoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPedido_platoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IPlatoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestauranteRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestaurante_empleadoRepository;
import com.pragma.plazoleta.infrastructure.out.jpa.token.TokenAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestauranteRepository objectRepository;
    private final IRestauranteEntityMapper objectEntityMapper;

    private final ICategoriaRepository categoriaRepository;
    private final ICategoriaEntityMapper categoriaEntityMapper;

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    private final IPedido_platoRepository pedido_platoRepository;
    private final IPedido_platoEntityMapper pedido_platoEntityMapper;

    private final IRestaurante_empleadoRepository restaurante_empleadoRepository;

    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;

    private final UserFeignClient userFeignClient;


    @Bean
    public IRestaurantePersistencePort objectPersistencePort() {
        return new RestauranteJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IRestauranteServicePort objectServicePort() {
        return new RestauranteUseCase(objectPersistencePort());
    }

    @Bean
    public ICategoriaPersistencePort categoriaPersistencePort() {
        return new CategoriaJpaAdapter(categoriaRepository, categoriaEntityMapper);
    }

    @Bean
    public ICategoriaServicePort categoriaServicePort() {
        return new CategoriaUseCase(categoriaPersistencePort());
    }

    @Bean
    public IPlatoPersistencePort platoPersistencePort() {
        return new PlatoJpaAdapter(platoRepository, platoEntityMapper);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {
        return new PlatoUseCase(platoPersistencePort());
    }

    @Bean
    public IPedidoServicePort pedidoServicePort(){
        return new PedidoUseCase(pedidoPersistencePort(), pedido_platoPersistencePort());
    }
    @Bean
    public IPedidoPersistencePort pedidoPersistencePort() {
        return new PedidoJpaAdapter(pedidoRepository, pedidoEntityMapper);
    }

    @Bean
    public IPedido_platoPersistencePort pedido_platoPersistencePort() {
        return new Pedido_platoJpaAdapter(pedido_platoRepository,pedido_platoEntityMapper);
    }


    @Bean
    public IRestaurante_empleadoPersistencePort restaurante_empleadoPersistencePort() {
        return new Restaurante_empleadoJpaAdapter(restaurante_empleadoRepository);
    }


    @Bean
    public IUserFeignClientPort userFeignClientPort() {
        return new UserFeignAdapter(userFeignClient);
    }

    @Bean
    public IToken token(){return new TokenAdapter();
    }

}