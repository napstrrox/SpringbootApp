package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

import com.hcl.SpringBootApp.model.FibonacciOutput;


@Component
public class FibonacciService{
	
	public FibonacciOutput fibonacci(Object num){
		FibonacciOutput output = new FibonacciOutput();
		long a = 0, b = 1, c;
		if(num instanceof Long) {
			Long newNum=new Long((long) num);
			if(num.equals(0)){
				throw new IllegalArgumentException ("Wrong input: " + newNum);
			}
			for(long i = 2; i <= newNum; i++) {
				c = a+b;
				a = b;
				b = c;
			}
			output.setNumber(b);
			return output;
		}
		throw new NumberFormatException("Wrong input Parameter");
	}
}