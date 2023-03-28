package com.pragma.plazoleta.infrastructure.out.jpa.entity;

import com.pragma.plazoleta.domain.model.Restaurante_empleadoModel;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestaurante_empleadoRepository;
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
import java.util.Date;
@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pedido_id", nullable = false)
    private Long id;

    @Column(length = 50)
    private Long cliente;

    @Column(length = 50)
    private Date fecha;

    @Column(length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Restaurante_empleadoEntity id_chef;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private RestauranteEntity id_restaurante;

}
