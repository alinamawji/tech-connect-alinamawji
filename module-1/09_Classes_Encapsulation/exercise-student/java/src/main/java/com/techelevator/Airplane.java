package com.techelevator;

public class Airplane {
    private final String planeNumber;
    private final int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private final int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalNumberOfSeats <= getAvailableFirstClassSeats()) {
                this.bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        } else {
            if (totalNumberOfSeats <= getAvailableCoachSeats()) {
                this.bookedCoachSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        }
    }
}
