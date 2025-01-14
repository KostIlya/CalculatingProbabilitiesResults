package org.algorithms;

public class Club {
    private final String name;
    private final String country;
    private final char group;
    private final int place;

    public Club(String name, String country, char group, int place) {
        this.name = name;
        this.country = country;
        this.group = group;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public char getGroup() {
        return group;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%c\t%d", name, country, group, place);
    }
}
