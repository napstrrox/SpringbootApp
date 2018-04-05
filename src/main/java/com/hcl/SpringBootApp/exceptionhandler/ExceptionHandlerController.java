package com.hcl.SpringBootApp.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handleException(Exception e){
		ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            Error response = new Error("400", e.getMessage());
            json = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
		
		return new ResponseEntity<Object>(json + "\n", HttpStatus.BAD_REQUEST);
	}
}
