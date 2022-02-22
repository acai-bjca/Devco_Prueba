package com.devco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Empleados {
    @Id
    @Column(name = "EMPLEADO_ID")
    private Integer empleadoId;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private Date apellido;
    
}
