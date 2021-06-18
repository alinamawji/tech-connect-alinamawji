package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		ArrayList<Integer> fibNums = new ArrayList<Integer>(
				Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)
		);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int num = Integer.parseInt(scanner.nextLine());

		if (num == 0) {
			System.out.println("0, 1");
		} else if (num == 1) {
			System.out.println("0, 1, 1");
		} else if (fibNums.contains(num)) {
			for (int i : fibNums) {
				if (i <= num) {
					System.out.print(i);
					if (i != num) {
						System.out.print(", ");
					}
				}
			}
		} else if ((fibNums.get(0) < num) && (fibNums.get(fibNums.size()-1) > num)) {
			for (int i : fibNums) {
				if (i < num) {
					if (i != fibNums.get(0)) {
						System.out.print(", ");
					}
					System.out.print(i);
				}
			}
		} else if (num > fibNums.get(fibNums.size()-1)) {
			int sum = fibNums.get(fibNums.size()-1);
			while (num > sum) {
				sum += fibNums.get(fibNums.size()-2);
				fibNums.add(sum);
			}
			if (num == (fibNums.get(fibNums.size()-2) + fibNums.get(fibNums.size()-1))) {
				fibNums.add(sum + num);
			}
			for (int i : fibNums) {
				if (i <= num) {
					if (i != fibNums.get(0)) {
						System.out.print(", ");
					}
					System.out.print(i);
				}
			}
		}
	}
}
