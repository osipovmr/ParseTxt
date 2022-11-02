package osipovmr;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static File test = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test.txt");
    public static File test2 = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test2.txt");
    public static File test3 = new File("/Users/vulpix_li/Downloads/ParseTxt/src/test3.txt");


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        //ReadFile.ReadFile(test);
        //ReadFile.ReadFile(test2);
        ReadFile.ReadFile(test3);


        //Similarity.findSimilarity(ReadFile.inputOne, ReadFile.inputTwo);
    }
}
