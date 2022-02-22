package com.devco.services;


import com.devco.dto.ApiResponse;

public interface IAsignacionesService {
	ApiResponse<Boolean> asignarDispositivo(String dispositivoId, Long empleadoId);
}
