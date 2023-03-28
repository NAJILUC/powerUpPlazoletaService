package com.pragma.plazoleta.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_plato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido_platoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pedido_plato_id", nullable = false)
    Long id;


    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    PedidoEntity id_pedido;

    @ManyToOne
    @JoinColumn(name = "plato_id", nullable = false)
    PlatoEntity id_plato;

    @Column(length = 50)
    Long cantidad;
}
