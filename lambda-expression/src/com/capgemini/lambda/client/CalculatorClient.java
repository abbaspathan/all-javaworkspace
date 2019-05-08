package com.capgemini.lambda.client;

import com.capgemini.lambda.model.Calculator;

public class CalculatorClient {

	public static void main(String[] args) {

		Calculator addition = (x, y) -> x + y;
		System.out.println(addition.calculate(12, 10));

		Calculator addition1 = (x, y) -> x - y;
		System.out.println(addition1.calculate(12, 10));
	}
}
