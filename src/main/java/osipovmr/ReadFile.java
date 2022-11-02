package osipovmr;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFile {

    public static List<String> ReadFile(File file) throws IOException {
        List<String> inputOne = new ArrayList<>();
        List<String> inputTwo = new ArrayList<>();
        List<String> inputThree = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            int numberOne = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOne; i++) {
                inputOne.add(scanner.nextLine());
            }
            int numberTwo = scanner.nextInt();
            for (int i = 0; i < numberTwo + 1; i++) {
                inputTwo.add(scanner.nextLine());
            }
        }
        inputTwo.remove(0);
        int repeat = Integer.max(inputOne.size(), inputTwo.size());
        for (int i = 0; i < repeat; i++) {
            inputThree.add("null");
        }
        for (int i = 0; i < inputOne.size(); i++) {
            for (int j = 0; j < inputTwo.size(); j++) {
                int maxLength = Integer.max(inputOne.get(i).length(), inputTwo.get(j).length());
                double sovpadaet = maxLength - StringUtils.getLevenshteinDistance(inputOne.get(i), inputTwo.get(j));
                if ((sovpadaet == inputOne.get(i).length()) || (sovpadaet == inputTwo.get(j).length()) || (sovpadaet > inputTwo.get(j).length() / 2)) {
                    inputThree.set(i, (inputOne.get(i) + ": " + inputTwo.get(j)));
                } else if (
                        (sovpadaet == 0)
                                &&
                                !(inputThree.contains(inputOne.get(i) + ": ?"))
                                &&
                                (!(inputOne.size() == 1))
                                &&
                                (!(inputTwo.size() == 2))
                ) {
                    inputThree.set(i, inputOne.get(i) + ": ?");
                } else if ((inputOne.size() == 1) && (inputTwo.size() == 1)) {
                    inputThree.set(0, inputOne.get(i) + ": " + inputTwo.get(j));
                } else if ((sovpadaet != 0) && (sovpadaet < inputTwo.get(j).length() / 3)) {
                } else if ((inputOne.size() == 1) && (inputTwo.size() == 2)) {
                    inputThree.set(0, (inputOne.get(0) + ": " + inputTwo.get(0)));
                    inputThree.set(1, (inputTwo.get(1) + ": ?"));
                }
            }
        }
        return inputThree;
    }
}
