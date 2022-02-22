package com.devco.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constants for requests to Azure Devops
 * 
 * @author aialfonso, icristancho, amancilla, admarino
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndPointsExternal {
	public static final String API_URI = "http://localhost:3000";
	public static final String DISPOSITIVO = "/dispositivos/";
	
}
