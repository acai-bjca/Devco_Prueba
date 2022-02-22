package com.devco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.devco.entity.Asignacion;


@Repository
public interface AsignacionesRepository extends JpaRepository<Asignacion, Integer> {

    @Query(value = "SELECT *  "+
            "FROM ASIGNACIONES asig " +
            "WHERE asig.DISPOSITIVO_ID = :dispositivoId AND asig.EMPLEADO_ID = :empleadoId "+
            "ORDER BY asig.FECHA_INICIO DESC", nativeQuery = true)
    List<Asignacion> findLastAsignacion (String dispositivoId, long empleadoId);

}
