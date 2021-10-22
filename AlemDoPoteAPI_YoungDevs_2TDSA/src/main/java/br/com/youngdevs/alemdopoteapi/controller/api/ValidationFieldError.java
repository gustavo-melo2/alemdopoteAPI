package br.com.youngdevs.alemdopoteapi.controller.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationFieldError {

	
	private String field;
	private String erro;
}
