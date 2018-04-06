package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;
@Component
public class FibonacciService {
	public Long getNthfibonacciNumber(Object num) 
	{
		Long newNum = Long.parseLong(num.toString());
		long num1 = 0, num2 = 1, num3;
		for (long i = 2; i <= newNum; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
		}
		return num2;
	}
}