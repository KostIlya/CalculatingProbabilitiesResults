package org.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserCSV {
    public static List<Club> parse(String pathToFile) {
        List<Club> data = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            String[] lines;
            while ((line = input.readLine()) != null) {
                lines = line.split(",");
                String name = lines[0];
                String country = lines[1];
                char group = lines[2].charAt(0);
                int place = Integer.parseInt(lines[3]);
                data.add(new Club(name, country, group, place));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
