package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileSplitter {
	static String path;
	static int numberOfFiles;
	static int maxLines;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		File inputFile = null;

		//get input file path
		System.out.print("Where is the input file (please include the path to the file)? ");
		path = input.nextLine();
		inputFile = new File(path);

		//get max lines of text
		System.out.print("How many lines of text (max) should there be in the split files? ");
		maxLines = input.nextInt();

		//print number of lines in input file
		int numberOfLines = Files.readAllLines(inputFile.toPath()).size();
		System.out.println("The input file has " + numberOfLines + " lines of text.");

		//determine number of files needed
		System.out.println("\nEach file that is created must have a sequential number assigned to it.");
		numberOfFiles = (int)Math.ceil((double)numberOfLines / (double)maxLines);
		System.out.println("\nFor a " + numberOfLines + " line input file \"input\".txt, this produces " + numberOfFiles + " output files.");

		//generate output
		splitFile(inputFile);
	}

	public static void splitFile(File fileToSplit) throws IOException {
		//get name of extension and file name
		String extension = "";
		String fileName = "";
		for (int i = path.length()-1; i > 0; i--) {
			if (path.charAt(i) == '.') {
				extension = path.substring(i);
				fileName = path.substring(0, i);
				break;
			}
		}

		//scanner to parse through source file
		Scanner sourceFile = new Scanner(fileToSplit);

		//create individual files
		for (int i = 1; i < numberOfFiles+1; i++) {
			File nextFile = new File(fileName + "-" + i + extension);
			FileWriter nextFileWriter = new FileWriter(nextFile);
			for (int line = 0; line < maxLines; line++) {
				if (sourceFile.hasNextLine()) {
					nextFileWriter.append(sourceFile.nextLine());
					nextFileWriter.flush();
				} else {
					break;
				}
			}
		}
	}

}
