package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileRead {

    /**
     * Read file using java 8
     * 
     * @param fileName
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String readFileV1(String fileName) throws IOException, URISyntaxException {
        StringBuilder sb = new StringBuilder();
        final URI uri = FileRead.class.getClassLoader().getResource(fileName).toURI();
        Files.lines(Paths.get(uri)).forEach((s) -> sb.append(s));
        return sb.toString();
    }

    /**
     * Read file using java <= 1.7
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readFileV2(String fileName) throws IOException {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            final String file = FileRead.class.getClassLoader().getResource(fileName).getFile();
            br = new BufferedReader(new FileReader(new File(file)));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

        } finally {
            if (br != null) {
                br.close();
            }

        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(FileRead.readFileV1("sample.txt"));
        System.out.println(FileRead.readFileV2("sample.txt"));
    }
}
