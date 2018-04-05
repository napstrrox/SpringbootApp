package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

import com.hcl.SpringBootApp.model.FibonacciOutput;


@Component
public class FibonacciService {
	
	public FibonacciOutput fibonacci(long num) {
		FibonacciOutput output = new FibonacciOutput();
		long a = 0, b = 1, c;
		
		if(num <= 0) {
			throw new IllegalArgumentException ("Wrong input: " + num);
		}
		
		for(long i = 2; i <= num; i++) {
			c = a+b;
			a = b;
			b = c;
		}
		output.setNumber(b);
		return output;
	}
}
