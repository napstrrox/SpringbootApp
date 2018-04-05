package com.hcl.SpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootApp.model.FibonacciOutput;
import com.hcl.SpringBootApp.service.FibonacciService;


@RestController
@RequestMapping("/api")
public class FibonacciController {
	
	@Autowired
	private FibonacciService fibonacciService;
	
	@RequestMapping(value="/Fibonacci", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> fibonacci(@RequestParam(value="n") long num) {
		long number = Long.valueOf(num);
		FibonacciOutput output = new FibonacciOutput();
		output= fibonacciService.fibonacci(number);
		return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body(output);
	}
	
}
