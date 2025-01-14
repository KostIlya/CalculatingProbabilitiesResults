package org.algorithms;

public class ProbabilityOfMeet {
    private final String club1;
    private final String club2;
    private final double probability;
    public ProbabilityOfMeet(String club1, String club2, double probability) {
        this.club1 = club1;
        this.club2 = club2;
        this.probability = probability;
    }
    public double getProbability() {
        return probability;
    }

    public String getClub1() {
        return club1;
    }

    public String getClub2() {
        return club2;
    }

    @Override
    public String toString() {
        return String.format("%s - %s : %.2f", club1, club2, probability);
    }
}
