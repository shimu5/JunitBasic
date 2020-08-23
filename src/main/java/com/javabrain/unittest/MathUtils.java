package com.javabrain.unittest;

;

public class MathUtils {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public double computeCircleArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	/*
	public void execute(Runnable command) {
		void start() {
			for(int i=0; i<=500000; i++) {
				System.out.println("i="+i);
			}
		}
		
	}*/
	
}
