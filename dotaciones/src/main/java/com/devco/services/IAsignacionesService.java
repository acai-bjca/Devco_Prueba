package com.devco.services;


import javax.inject.Singleton;

import com.devco.dto.ApiResponse;

@Singleton
public interface IAsignacionesService {
	ApiResponse<Boolean> asignarDispositivo(String dispositivoId, Long empleadoId);
}
