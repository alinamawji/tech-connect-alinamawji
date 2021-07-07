package com.techelevator;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//get file path
		Scanner fileScanner = new Scanner(System.in);
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String path = scanner.nextLine();
		File inputFile = new File(path);

		//create buffered reader
		try {
			fileScanner = new Scanner(inputFile);
		} catch (Exception e) {
			System.out.println("Cannot create Scanner with this file.");
			System.exit(1);
		}

		//get desired keyword
		System.out.println("What is the search word you are looking for?");
		String keyword = "";
		try {
			keyword = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Must be a string.");
			System.exit(1);
		}

		//determine if search is case-sensitive
		String isCaseSensitive = "";
		System.out.println("Should the search be case sensitive? (Y\\N)");
		try {
			isCaseSensitive = scanner.nextLine().toUpperCase();
		} catch (Exception e) {
			System.out.println("Must be a string, Y or N.");
			System.exit(1);
		}

		//find lines where keyword is present
		String output = scanFile(fileScanner, keyword, isCaseSensitive);
		System.out.println(output);

	}

	public static String scanFile(Scanner fileScanner, String keyword, String isCaseSensitive) {		String line = null;
		line = fileScanner.nextLine();

		int lineNumber = 1;
		String output = "";

		if (isCaseSensitive.equals("Y")) {
			while (fileScanner.hasNextLine()) {
				if (wordIsPresentCaseSensitive(keyword, line)) {
					output += (lineNumber + ") " + line + "\n");
				}
				lineNumber += 1;
				line = fileScanner.nextLine();
			}
		} else {
			while (fileScanner.hasNextLine()) {
				if (wordIsPresentCaseInsensitive(keyword, line)) {
					output += (lineNumber + ") " + line + "\n");
				}
				lineNumber += 1;
				line = fileScanner.nextLine();
			}
		}

		return output;
	}

	public static boolean wordIsPresentCaseSensitive(String keyword, String line) {
		return (line.contains(keyword));
	}

	public static boolean wordIsPresentCaseInsensitive(String keyword, String line) {
		String caseInsensitiveKeyword = keyword.toLowerCase();
		String caseInsensitiveLine = line.toLowerCase();
		return (caseInsensitiveLine.contains(caseInsensitiveKeyword));
	}

}
