package org.algorithms;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class API {
    private final List<ProbabilityOfMeet> resultList;

    public API() {
        resultList = new ArrayList<>();
    }

    public void calculate(List<Club> data) {
        for (var d : data) {
            if (d.getPlace() == 1) {
                double count = 0;
                List<String> clubs2Name = new ArrayList<>();

                for (var el : data) {
                    if (!d.equals(el)) {
                        if ((el.getPlace() != 1) &&
                                (!d.getCountry().equals(el.getCountry())) &&
                                (d.getGroup() != el.getGroup())) {
                            clubs2Name.add(el.getName());
                            count++;
                        } else {
                            resultList.add(new ProbabilityOfMeet(d.getName(), el.getName(), 0));
                        }
                    }
                }

                for (var cl2 : clubs2Name) {
                    resultList.add(new ProbabilityOfMeet(d.getName(), cl2, 1 / count));
                }
            }
        }
    }

    public void writeFile(String pathToFile, boolean isNullProbability) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(pathToFile))) {
            int maxTab = 4;
            int tabToSpace = 4;
            StringBuilder builder;

            output.write("Клуб 1\t\t\t  - Клуб 2\t\t\t : Вероятность встречи\n");
            if (!isNullProbability) {
                for (var res : resultList) {
                    builder = new StringBuilder();
                    if (res.getProbability() != 0) {
                        builder.append(res.getClub1());
                        for (int i = 0; i < maxTab - res.getClub1().length() / tabToSpace; i++) {
                            builder.append("\t");
                        }
                        builder.append("  - ").append(res.getClub2());
                        for (int i = 0; i < maxTab - res.getClub2().length() / tabToSpace; i++) {
                            builder.append("\t");
                        }
                        builder.append(" : ");
                        builder.append(String.format("%.2f", res.getProbability()));

                        output.write(builder + "\n");
                    }
                }
            } else {
                for (var res : resultList) {
                    builder = new StringBuilder();
                    builder.append(res.getClub1());
                    for (int i = 0; i < maxTab - res.getClub1().length() / tabToSpace; i++) {
                        builder.append("\t");
                    }
                    builder.append("  - ").append(res.getClub2());
                    for (int i = 0; i < maxTab - res.getClub2().length() / tabToSpace; i++) {
                        builder.append("\t");
                    }
                    builder.append(" : ");
                    builder.append(String.format("%.2f", res.getProbability()));

                    output.write(builder + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileCSV(String pathToFileCSV, boolean isNullProbability) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(pathToFileCSV))) {
            StringBuilder builder;

            output.write("Клуб 1,Клуб 2,Вероятность встречи");
            output.write("\n");
            if (!isNullProbability) {
                for (var res : resultList) {
                    builder = new StringBuilder();
                    if (res.getProbability() != 0) {
                        builder.append(res.getClub1()).append(",");
                        builder.append(res.getClub2()).append(",");
                        builder.append(String.format(Locale.ROOT, "%.2f", res.getProbability()));

                        output.write(builder.toString());
                        output.write("\n");
                    }
                }
            } else {
                for (var res : resultList) {
                    builder = new StringBuilder();
                    builder.append(res.getClub1()).append(",");
                    builder.append(res.getClub2()).append(",");
                    builder.append(String.format(Locale.ROOT, "%.2f", res.getProbability()));

                    output.write(builder.toString());
                    output.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(boolean isNullProbability) {
        int maxTab = 4;
        int tabToSpace = 4;
        StringBuilder builder;

        System.out.println("Клуб 1\t\t\t  - Клуб 2\t\t\t : Вероятность встречи\n");
        if (!isNullProbability) {
            for (var res : resultList) {
                builder = new StringBuilder();
                if (res.getProbability() != 0) {
                    builder.append(res.getClub1());
                    for (int i = 0; i < maxTab - res.getClub1().length() / tabToSpace; i++) {
                        builder.append("\t");
                    }
                    builder.append("  - ").append(res.getClub2());
                    for (int i = 0; i < maxTab - res.getClub2().length() / tabToSpace; i++) {
                        builder.append("\t");
                    }
                    builder.append(" : ");
                    builder.append(String.format("%.2f", res.getProbability()));
                    System.out.println(builder);
                }
            }
        } else {
            for (var res : resultList) {
                builder = new StringBuilder();
                builder.append(res.getClub1());
                for (int i = 0; i < maxTab - res.getClub1().length() / tabToSpace; i++) {
                    builder.append("\t");
                }
                builder.append("  - ").append(res.getClub2());
                for (int i = 0; i < maxTab - res.getClub2().length() / tabToSpace; i++) {
                    builder.append("\t");
                }
                builder.append(" : ");
                builder.append(String.format("%.2f", res.getProbability()));
                System.out.println(builder);
            }
        }
    }
}
