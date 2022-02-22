package com.devco.business;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.devco.config.EndPointsExternal;
import com.devco.dto.DispositivoDTO;
import com.devco.exceptions.APIException;
import com.devco.utils.Constants;

@Service
public class ExternalAPIBusiness {
	/**
	 * @param dispositivoId
	 * @return DispositivoDTO
	 */
	public DispositivoDTO getDispositivo(String dispositivoId) {
		RestTemplate restTemplate = new RestTemplate();
		DispositivoDTO dispositivoDTO;
		String url = EndPointsExternal.API_URI + EndPointsExternal.DISPOSITIVO + dispositivoId;
		try {
			dispositivoDTO = restTemplate.getForObject(url, DispositivoDTO.class);
			return dispositivoDTO;
		} catch (HttpClientErrorException ex) {
			throw new APIException(ex.getMessage(), HttpStatus.BAD_REQUEST, Constants.MESSAGE_NOT_FOUNT_DISP,
					Constants.EXTERNALAPIBUSINESS_GETDISPOSITIVO);
		}
	}
}
