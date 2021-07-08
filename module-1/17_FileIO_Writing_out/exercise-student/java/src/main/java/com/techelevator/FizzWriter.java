package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FizzWriter {
	static FileWriter writeFile = null;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		File destinationFile = null;

		//get destination file path
		System.out.println("Please enter the file path of the destination file.");
		String path = input.nextLine();

		//create destination file
		try {
			destinationFile = new File(path);
		} catch (Exception e) {
			System.out.println("Cannot use this file.");
			System.exit(1);
		}

		//create FileWriter
		try {
			writeFile = new FileWriter(destinationFile, false);
		} catch (IOException e) {
			System.out.println("Cannot make a FileWriter with this file.");
			System.exit(1);
		}

		//write results of fizzbuzz in writeFile
		for (int i = 1; i < 301; i++) {
			if (isDivisibleBy3And5(i)) {
				writeToFile("FizzBuzz");
			} else if (isDivisibleBy3(i)) {
				writeToFile("Fizz");
			} else if (isDivisibleBy5(i)) {
				writeToFile("Buzz");
			} else {
				writeToFile(Integer.toString(i));
			}
		}

	}

	public static boolean isDivisibleBy3And5(int n) {
		return ((n % 3 == 0) && (n % 5 == 0));
	}

	public static boolean isDivisibleBy3(int n) {
		boolean contains3 = String.valueOf(n).contains("3");
		return ((n % 3 == 0) || contains3);
	}

	public static boolean isDivisibleBy5(int n) {
		boolean contains5 = String.valueOf(n).contains("5");
		return ((n % 5 == 0) || contains5);
	}

	public static void writeToFile(String s) {
		try {
			writeFile.append(s + "\r\n");
			writeFile.flush();
		} catch (IOException e) {
			System.out.println("Cannot write to file.");
			System.exit(1);
		}
	}

}
