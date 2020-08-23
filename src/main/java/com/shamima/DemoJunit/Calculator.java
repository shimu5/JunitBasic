package com.shamima.DemoJunit;

public class Calculator {

	CalculatorService service;
	
	public int add(int i, int j) {
		return i+j;
		//return service.add(i, j);
	}
}
