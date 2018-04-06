package com.hcl.SpringBootApp.controller;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootApp.service.FibonacciService;

@RestController
@RequestMapping("/api")
public class FibonacciController {
	
	@Autowired
	private FibonacciService fibonacciService;
	
	@RequestMapping(value="/Fibonacci", method=RequestMethod.GET)
	public ResponseEntity<Object> getNthFibonacciNumber(@RequestParam(value = "n") Object num) {
		try {
			Long input = new Long(num.toString());
			if (input == null || input < 0) {
				throw new InvalidParameterException("Input is null or Empty.");
			}
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("Invalid Input Type");
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(fibonacciService.getNthfibonacciNumber(num));
	}
}
