package com.capgemini.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPerformAdditionWithTwoPositiveIntegers() {
		when(service.addition(6, 4)).thenReturn(10);
		assertEquals(10, application.performAddition(6, 4));
	}

	@Test
	public void testPerformAdditionWithTwoNegativeIntegers() {
		when(service.addition(-6, -4)).thenReturn(-10);
		assertEquals(-10, application.performAddition(-6, -4));
	}

	@Test
	public void testPerformAdditionWithOneNegativeIntegers() {
		when(service.addition(6, -4)).thenReturn(2);
		assertEquals(2, application.performAddition(6, -4));
	}

	@Test
	public void testPerformSubtractionWithTwoPositiveIntegers() {
		when(service.subtraction(6, 4)).thenReturn(2);
		assertEquals(2, application.performSubtraction(6, 4));
	}

	@Test
	public void testPerformSubtractionWithTwoNegativeIntegers() {
		when(service.subtraction(-6, -4)).thenReturn(-2);
		assertEquals(-2, application.performSubtraction(-6, -4));
	}

	@Test
	public void testPerformSubtractionWithOneNegativeIntegers() {
		when(service.subtraction(6, -4)).thenReturn(10);
		assertEquals(10, application.performSubtraction(6, -4));
	}

	@Test
	public void testPerformMultiplicationWithTwoPositiveIntegers() {
		when(service.multiplication(6, 4)).thenReturn(24);
		assertEquals(24, application.performMultiplication(6, 4));
	}

	@Test
	public void testPerformMultiplicationWithTwoNegativeIntegers() {
		when(service.multiplication(-6, -4)).thenReturn(24);
		assertEquals(24, application.performMultiplication(-6, -4));
	}

	@Test
	public void testPerformMultiplicationWithOneNegativeIntegers() {
		when(service.multiplication(6, -4)).thenReturn(-24);
		assertEquals(-24, application.performMultiplication(6, -4));
	}

	@Test
	public void testFindFactorialWithPositiveInteger() {
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.findFactorial(5));
	}

	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() {
		doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
		application.performDivision(10, 0);
	}

	@Test
	public void testperformDivisionWithTwoIntegers() {
		when(service.division(9, 3)).thenReturn(3);
		assertEquals(3, application.performDivision(9, 3));
	}
	
	@Test
	public void testPerformDivisionWithTwoNegativeIntegers() {
		when(service.division(-6, -3)).thenReturn(2);
		assertEquals(2, application.performDivision(-6, -3));
	}

	@Test
	public void testPerformDivisionWithOneNegativeIntegers() {
		when(service.division(6, -3)).thenReturn(-2);
		assertEquals(-2, application.performDivision(6, -3));
	}
}
