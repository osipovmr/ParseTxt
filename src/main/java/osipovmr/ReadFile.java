package osipovmr;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFile {

    public static void ReadFile(File file) throws IOException {
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
        System.out.println(repeat);
        for (int i = 0; i < repeat; i++) {
            inputThree.add("null");
        }

        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < inputTwo.size(); j++) {
                System.out.println("Сравниваем: " + inputOne.get(i) + " и " + inputTwo.get(j));
                int maxLength = Integer.max(inputOne.get(i).length(), inputTwo.get(j).length());
                System.out.println("Максимальное количество символов = " + maxLength);
                int sovpadaet = maxLength - StringUtils.getLevenshteinDistance(inputOne.get(i), inputTwo.get(j));
                System.out.println("Количество совпадающих символов = " + sovpadaet);
                if ((sovpadaet == inputOne.get(i).length()) || (sovpadaet == inputTwo.get(j).length()) || (sovpadaet > inputTwo.get(j).length() / 2)) {
                    inputThree.set(i, (inputOne.get(i) + ": " + inputTwo.get(j)));
                    System.out.println("Есть совпадение! Добавляем в список.");
                } else if ((sovpadaet == 0) && !(inputThree.contains(inputOne.get(i) + ": ?"))) {
                    inputThree.set(i, inputOne.get(i) + ": ?");
                    System.out.println("Совпадений нет! Не добавляем в список.");
                } else if ((inputOne.size() == 1) && (inputTwo.size() == 1)) {
                    inputThree.set(0, inputOne.get(i) + ": " + inputTwo.get(j));
                }
            }
        }
        System.out.println(inputThree);
    }


}
