package com.rahul.string;

public class RecursionPractice {

	public void printFibonacci() {
		// print the first two numbers
		System.out.print("0, 1, ");
		printFibonacci(0, 1);
	}

	private void printFibonacci(int num1, int num2) {
		if (num1 > 1000)
			return;
		int num3 = num1 + num2;
		System.out.print(num3 + ", ");
		printFibonacci(num2, num3);

	}

}
