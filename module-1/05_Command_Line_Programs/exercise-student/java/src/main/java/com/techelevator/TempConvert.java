package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		String newMeasure = "C";
		double newTemp = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		double temp = Integer.parseInt(scanner.nextLine());

		System.out.print("Is the temperature in (C)elsius, or (F)arenheit? ");
		String measure = scanner.nextLine();

		if (measure.equals("C")) {
			newTemp = temp * 1.8  + 32;
			newMeasure = "F";
		} else if (measure.equals("F")) {
			newTemp = (temp - 32) / 1.8;
			newMeasure = "C";
		}

		System.out.print((int)temp + measure + " is " + (int)newTemp + newMeasure + ".");


	}

}
