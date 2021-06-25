

package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private final int possibleMarks;
    private final String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double percentage = (double)earnedMarks / (double)possibleMarks;

        if (percentage >= 0.9) {
            this.letterGrade = "A";
        } else if (percentage >= 0.8) {
            this.letterGrade = "B";
        } else if (percentage >= 0.7) {
            this.letterGrade = "C";
        } else if (percentage >= 0.6) {
            this.letterGrade = "D";
        } else {
            this.letterGrade = "F";
        }

        return letterGrade;

    }
}
