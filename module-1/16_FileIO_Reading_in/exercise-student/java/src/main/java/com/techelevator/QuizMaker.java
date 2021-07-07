package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class QuizMaker {
	static Scanner scanner = new Scanner(System.in);
	String path;

	Scanner readFile;
	FileWriter writeToFile;

	public static void main(String[] args) {
		//get file path
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String path = scanner.nextLine();

		//ask if user would like to be quizzed or create questions
		System.out.println("Would you like to (1) take the quiz or (2) create more questions? Please enter 1 or 2.");
		String answer = scanner.nextLine();

		//option 1: quiz the user
		if (answer.equals("1")) {
			//initialize scanner
			Scanner readFile = null;

			//create file and scanner
			try {
				File file = new File(path);
				readFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				System.exit(1);
			}

			//go through questions in file
			readQuizQuestions(readFile);

		}

		//option 2: get questions from user
		if (answer.equals("2")) {
			//initialize user question input
			String input = "";

			//write questions using createQuestion method
			try {
				//create new filewriter
				FileWriter writeFile = new FileWriter(path, true);
				while (true) {
					//get question from user, or q if user is done
					System.out.println("Please enter a question. If you would like to stop writing, enter \"q\".");
					input = scanner.nextLine();
					//check if user is done writing (q)
					if (input.equals("q")) {
						System.out.println("Exiting application.");
						System.exit(1);
					}
					//if user not done, create question
					writeFile.append(createQuestion(input));
					writeFile.flush();
					writeFile.close();
				}
			} catch(IOException e) {
				System.out.println("Cannot create FileWriter with this file.");
				System.exit(1);
			}
		}
	}

	public static String createQuestion(String question) {
		Random rand = new Random();
		String output = "";

		System.out.println("Please enter the correct answer.");
		String correctAnswer = scanner.nextLine();

		System.out.println("Please enter another answer.");
		String answer1 = scanner.nextLine();

		System.out.println("Please enter another answer.");
		String answer2 = scanner.nextLine();

		System.out.println("Please enter another answer.");
		String answer3 = scanner.nextLine();

		QuizQuestion newQuestion = new QuizQuestion(question, correctAnswer, answer1, answer2, answer3);
		int n = rand.nextInt(4) + 1;

		switch (n) {
			case 1:
				output = newQuestion.createQuestionA();
				break;
			case 2:
				output = newQuestion.createQuestionB();
				break;
			case 3:
				output = newQuestion.createQuestionC();
				break;
			case 4:
				output = newQuestion.createQuestionD();
				break;
		}
		return output;
	}

	public static void readQuizQuestions(Scanner readFile) {
		int numberCorrect = 0;
		int numberAnswered = 0;
		int correctAnswer = 0;
		String quizInput;
		int answerChoice;

		//while there are still questions listed
		while (readFile.hasNextLine()) {
			// split the line and print the question
			String[] line = readFile.nextLine().split("\\|");
			System.out.println(line[0]);

			//print out each of the answers
			for (int i = 1; i < 5; i++) {
				String s = line[i];
				System.out.print(i + ". ");
				if (s.endsWith("*")) {
					correctAnswer = i;
					System.out.println(s.substring(0, s.length()-1));
				} else {
					System.out.println(s);
				}
			}

			//ask user for their answer
			System.out.print("\nYour answer: ");
			numberAnswered += 1;

			//error checking for int
			quizInput = scanner.nextLine();
			if (isThisInt(quizInput)) {
				answerChoice = Integer.parseInt(quizInput);
			} else {
				answerChoice = 0;
			}

			//check if answer is correct
			if (answerChoice == correctAnswer) {
				System.out.println("RIGHT!\n");
				numberCorrect += 1;
			} else {
				System.out.println("WRONG!\n");
			}
		}

		//print how many answers were correct
		System.out.println("You got " + numberCorrect + " answer(s) correct out of the " + numberAnswered + " question(s) asked.");
	}

	public static boolean isThisInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
