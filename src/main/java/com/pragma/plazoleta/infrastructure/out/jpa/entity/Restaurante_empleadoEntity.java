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
import javax.persistence.Table;

@Entity
@Table(name = "restaurante_empleadoEntity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurante_empleadoEntity {


    @Id
    @Column(name = "persona_id", nullable = false)
    private Long id_persona;

    @Column(name = "id_restaurante", nullable = false)
    private Long id_restaurante;

}
