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
@Table(name = "ASIGNACIONES")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASIGNACIONES")
    @SequenceGenerator(name = "SEQ_ASIGNACIONES", sequenceName = "SEQ_ASIGNACIONES", allocationSize = 1)
    @Column(name = "ASIGNACION_ID")
    private Long asignacionId;
    @Column(name = "DISPOSITIVO_ID")
    private String dispositivoId;
    @Column(name = "EMPLEADO_ID")
    private Long empleadoId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_INICIO")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_FIN")
    private Date endDate;
    
}
