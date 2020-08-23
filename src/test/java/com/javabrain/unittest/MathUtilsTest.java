package com.javabrain.unittest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

	MathUtils mathutil=null;
	TestInfo testinfo;
	TestReporter testreporter;

	@BeforeAll
	public void beforeInit() {
		System.out.println("This needs to run before all.....");
	}

	@BeforeEach
	public  void setTest(TestInfo testinfo, TestReporter testreporter) {
		this.testinfo = testinfo;
		this.testreporter = testreporter;
		mathutil = new MathUtils();
		testreporter.publishEntry(" Running "+ testinfo.getDisplayName()+ " with tags "+testinfo.getTags());
		
	}

	@AfterEach
	public  void cleanup() {
		System.out.println("Cleaning..up.....");
	}

	@Test
	public void testUtilsAsserEquals() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		
		MathUtils mathutil= new MathUtils();
		int expected = 5;
		int actual;
		actual = mathutil.add(2,3);
		assertEquals(expected,actual );
	}
	
	
	@Test
	@Tag("Math")
	public void testUtilsAsserMultiply() {
		System.out.println(" Running "+ testinfo.getDisplayName()+ " with tags "+testinfo.getTags());
		MathUtils mathUtils= new MathUtils();
		int expected = 6;
		int actual;
		actual = mathUtils.multiply(3, 2);
		assertEquals(expected,actual );
	}

	@Test
	@DisplayName("Mathutil divide test")
	@EnabledOnOs(OS.LINUX)
	@EnabledOnJre(JRE.JAVA_14)
	public void testDivide() {
		assertThrows(ArithmeticException.class,() -> mathutil.divide(1, 0),"Divide by zero Exception" );
	}

	
	@Tag("DEV")
	@Test
	@DisplayName("We use Lambda here in failing message to create lazy instatiation of message if failed")
	void testCalcOne() {
		int expected = 5;
		int actual = mathutil.add(2, 2); 
		assertEquals(expected, actual, ()-> "Expected was "+expected + " but got" + actual );
	}

	@Tag("PROD")
	@Disabled
	@Test
	void testCalcTwo() {
		System.out.println("======TEST TWO EXECUTED=======");
		assertEquals(6, mathutil.add(2, 4));
	}
	
	
	@Nested
	class AddTest {
		@Test
		@DisplayName("Add two positive numbers")
		void testAddingTwoPositives() {
			assertEquals(2, mathutil.add(1, 1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		@DisplayName("Add two negative numbers")
		void testAddingTwoNegatives() {
			assertEquals(-2, mathutil.add(-1, -1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		@DisplayName("Add a positive and negative number")
		void testAddingAPositiveAndANegative() {
			assertEquals(0, mathutil.add(-1, 1), 
					"Add method should return the sum of two numbers");
		}
	}
	
	@Tag("PROD")
	@Test 
	void testMultiply() {
		assertAll(
				() -> assertEquals(0, mathutil.multiply(1, 0)),
				() -> assertEquals(1, mathutil.multiply(1, 1)),
				() -> assertEquals(6, mathutil.multiply(2, 3))
				);
	}
	
	@Test 
	@RepeatedTest(3)
	void computeCircleArea(RepetitionInfo repetitionInfo) {
		if(repetitionInfo.getCurrentRepetition()==1) {
			System.out.println("Do different things, depend on repitition");
		}
		assertEquals(314.1592653589793, mathutil.computeCircleArea(10), 
				"Should return right circle area");
	}

	/*@Test
	public void timeoutNotExceeded() {
	  // The following assertion succeeds, and returns the supplied object.
	  assertTimeout(Duration.ofMillis(1000), mathutil.PrintOut(),"hello");

	 }*/
}
