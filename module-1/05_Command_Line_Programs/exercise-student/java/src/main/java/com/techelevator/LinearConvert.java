package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		String newMeasure = "m";
		double newLength = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		double length = Integer.parseInt(scanner.nextLine());

		System.out.print("Is the temperature in (m)eter, or (f)eet? ");
		String measure = scanner.nextLine();

		if (measure.equals("m")) {
			newLength = length * 3.2808399;
			newMeasure = "f";
		} else if (measure.equals("f")) {
			newLength = length * 0.3048;
			newMeasure = "m";
		}

		System.out.print((int)length + measure + " is " + (int)newLength + newMeasure + ".");


	}

}
