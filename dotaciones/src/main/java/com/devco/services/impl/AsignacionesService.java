package com.devco.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import com.devco.business.ExternalAPIBusiness;
import com.devco.dto.ApiResponse;
import com.devco.dto.DispositivoDTO;
import com.devco.entity.Asignacion;
import com.devco.exceptions.APIException;
import com.devco.repository.AsignacionesRepository;
import com.devco.services.IAsignacionesService;
import com.devco.utils.Constants;

import java.util.Date;
import java.util.List;

@Service
public class AsignacionesService implements IAsignacionesService{

	@Inject
	private ExternalAPIBusiness externalAPIBusiness;

	@Inject
	private AsignacionesRepository asignacionesRepository;

	/**
	 * Build the response DPTO with the data required when logging in
	 * 
	 * @param trader
	 * @return TraderLoginDTO
	 */
	public ApiResponse<Boolean> asignarDispositivo(String dispositivoId, Long empleadoId) {
		DispositivoDTO dispositivoDTO = externalAPIBusiness.getDispositivo(dispositivoId);
		if (dispositivoDTO != null) {
			List<Asignacion> asignaciones = asignacionesRepository.findLastAsignacion(dispositivoId, empleadoId);
			Asignacion newAsignacion = new Asignacion();
			if (asignaciones.size() == 0 || (asignaciones.size() > 0 && asignaciones.get(0).getEndDate() != null && estaAsignadoALaFecha(asignaciones.get(0).getEndDate()))) {
				newAsignacion.setDispositivoId(dispositivoId);
				newAsignacion.setEmpleadoId(empleadoId);
				newAsignacion.setStartDate(new Date());
				//Capturar excepciones de base de datos. Ejem: empleado no existente
				try {
					asignacionesRepository.save(newAsignacion);
					return new ApiResponse<Boolean>(true, Constants.SUCCESS_REQUEST);
				}catch(Exception e) {
					return new ApiResponse<Boolean>(false, Constants.BAD_REQUEST);
				}
				
			}else {
				return new ApiResponse<Boolean>(false, Constants.ALREADY_ASSIGNED);
			}
		} else {
			throw new APIException(null, HttpStatus.NOT_FOUND, Constants.MESSAGE_NOT_FOUNT_DISP,
					Constants.EXTERNALAPIBUSINESS_GETDISPOSITIVO);
		}
	}

	public boolean estaAsignadoALaFecha(Date date) {
		Date actualDate = new Date();
		int diaActual = actualDate.getDay();
		int dia = date.getDay();
		return date.before(actualDate) && diaActual != dia;
	}
}