package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IPlatoServicePort;
import com.pragma.plazoleta.domain.exception.DomainException;
import com.pragma.plazoleta.domain.model.PlatoModel;
import com.pragma.plazoleta.domain.spi.IPlatoPersistencePort;

import java.util.ArrayList;
import java.util.List;

public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;

    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort) {
        this.platoPersistencePort = platoPersistencePort;
    }

    @Override
    public void savePlato(PlatoModel platoModel) {
        platoModel.setActivo(true);
        platoPersistencePort.savePlato(platoModel);
    }

    @Override
    public List<PlatoModel> getAllPlatos() {
        return platoPersistencePort.getAllPlatos();
    }

    @Override
    public PlatoModel getPlatoById(Long id) {
        List<PlatoModel> platos = getAllPlatos();
        for (PlatoModel plato: platos) {
            if(plato.getId()==id) return plato;
        }
        return null;
    }

    @Override
    public void updatePlato(PlatoModel platoModel) {
        PlatoModel plato = getPlatoById(platoModel.getId());
        if(!platoModel.getDescripcion().isEmpty())plato.setDescripcion(platoModel.getDescripcion());
        if(platoModel.getPrecio()!=null)plato.setPrecio(platoModel.getPrecio());
        savePlato(plato);
    }

    @Override
    public void statusPlato(PlatoModel platoModel) {
        PlatoModel plato = getPlatoById(platoModel.getId());
        plato.setActivo(platoModel.getActivo());
        plato.setNombre("Si funciona");
        plato.getActivo();
        platoPersistencePort.savePlato(plato);
    }

    @Override
    public List<PlatoModel> getAllPlatosRestaurant(Long restaurante, Integer page, Integer size) {
        List<PlatoModel> allPlatos = platoPersistencePort.getAllPlatosRestaurant(page,size);
        List<PlatoModel> platosRestaurant = new ArrayList<>();
        for (PlatoModel plato:allPlatos) {
            if(plato.getRestaurante().getId()==restaurante)platosRestaurant.add(plato);
        }
        return platosRestaurant;
    }
}