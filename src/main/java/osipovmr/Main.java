package osipovmr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static File test = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test.txt");
    public static File test2 = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test2.txt");
    public static File test3 = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test3.txt");


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Files.write(Paths.get("output.txt"), ReadFile.ReadFile(test), StandardOpenOption.CREATE);
        Files.write(Paths.get("output2.txt"), ReadFile.ReadFile(test2), StandardOpenOption.CREATE);
        Files.write(Paths.get("output3.txt"), ReadFile.ReadFile(test3), StandardOpenOption.CREATE);
    }
}
