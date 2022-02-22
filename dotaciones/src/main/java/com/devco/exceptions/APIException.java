package com.devco.exceptions;



import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIException extends RuntimeException {
	private static final long serialVersionUID = 1684647613481663075L;
	private String code;
	private HttpStatus status;
	private String message;
	private String method;
}
