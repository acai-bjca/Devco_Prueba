package com.devco.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ApiResponse<T> {
	private T data;
	private String notification;
}
