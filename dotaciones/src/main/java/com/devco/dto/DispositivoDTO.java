package com.devco.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDTO {
	private String id;
	private String nombre;
	private String tipo;
	private String OS;
}
