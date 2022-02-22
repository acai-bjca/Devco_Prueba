package com.devco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.devco.config.Endpoints;
import com.devco.dto.ApiResponse;
import com.devco.exceptions.APIException;
import com.devco.services.impl.AsignacionesService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.URI_BASE)
public class Controller {

	@Autowired
	private AsignacionesService asignacionesService;

	@PostMapping(Endpoints.URL_DISPOSITIVO)
	public ResponseEntity<ApiResponse<Boolean>> asignarDotacion(@PathVariable String dispositivoId,
			@PathVariable Long empleadoId) {
		try {
			ApiResponse<Boolean> apiResponse = asignacionesService.asignarDispositivo(dispositivoId, empleadoId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(apiResponse);
		} catch (APIException e) {
			return ResponseEntity.status(e.getStatus()).body(new ApiResponse<Boolean>(false, e.getMessage()));
		}
	}
}
