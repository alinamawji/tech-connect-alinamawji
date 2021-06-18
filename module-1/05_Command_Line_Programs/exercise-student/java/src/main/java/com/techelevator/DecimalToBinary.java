package com.techelevator;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String[] values = scanner.nextLine().split(" ");

		for (String i : values) {
			int num = Integer.parseInt(i);
			String binary = Integer.toBinaryString(num);
			System.out.println(num + " in binary is " + binary);
		}


	}

}
