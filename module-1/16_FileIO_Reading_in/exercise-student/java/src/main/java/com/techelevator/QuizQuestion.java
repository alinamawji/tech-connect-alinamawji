package com.techelevator;

public class QuizQuestion {
    private final String question;
    private final String correctAnswer;
    private final String answer1;
    private final String answer2;
    private final String answer3;

    public QuizQuestion(String question, String correctAnswer, String answer1, String answer2, String answer3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String createQuestionA() {
        return question + "|" + correctAnswer + "*|" + answer1 + "|" + answer2 + "|" + answer3 + "\n";
    }

    public String createQuestionB() {
        return question + "|" + answer1 + "|" + correctAnswer + "*|" + answer2 + "|" + answer3 + "\n";
    }

    public String createQuestionC() {
        return question + "|" + answer1 + "|" + answer2 + "|" + correctAnswer + "*|" + answer3 + "\n";
    }

    public String createQuestionD() {
        return question + "|" + answer1 + "|" + answer2 + "|" + answer3 + "|" + correctAnswer + "*\n";
    }
}
