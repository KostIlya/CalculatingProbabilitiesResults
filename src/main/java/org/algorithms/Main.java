package org.algorithms;

import java.util.List;

public class Main {
    private final static String pathToFileRead = "src\\main\\resources\\data.csv";
    private final static String pathToFileWrite = "src\\main\\resources\\output.txt";
    private final static String pathToFileCSVWrite = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        List<Club> clubs = ParserCSV.parse(pathToFileRead);

        API api = new API();

        api.calculate(clubs);

        api.print(true);
        api.writeFile(pathToFileWrite, true);
        api.writeFileCSV(pathToFileCSVWrite, true);
    }
}