package com.shamima.DemoJunit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCalculator {

	 Calculator c = null;
	
	@BeforeEach
	public void Setup() {
		c = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertEquals(5, c.add(3, 2));
	}
	
	@AfterEach
	public void destry() {
		c = null;
	}

}
