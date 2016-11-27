package constructs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liju on 11/17/16.
 */
public class TryWithResources {

    public static String readWithSuppressedException(String path) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
        } catch (Exception e) {
            // get all the suppressed exceptions
            for (int i = 0; i < e.getSuppressed().length; i++) {
                System.out.println("Suppressed exception : " + i);
                e.printStackTrace();
            }
        }
        return line;
    }

    public static String readFirstLineFromFile(String path) throws IOException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
        }
        return line;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFirstLineFromFile("/Users/liju/Documents/gitprojects/code-practice/java-core/src/main/resources/sample.txt"));
    }
}
