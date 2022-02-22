package com.devco.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints {
	public static final String URI_BASE = "v1/dotaciones";
	public static final String URL_DISPOSITIVOS = "/dispositivos";
	public static final String URL_DISPOSITIVO = "/dispositivo/{dispositivoId}/empleado/{empleadoId}";
}
