package file;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Liju on 11/16/2016.
 */
public class FileUtil {

    //reading file from resource
    public String readFromResource(String filename) throws URISyntaxException, IOException {
        final byte[] bytes = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("sample.txt").toURI()));
        return new String(bytes, StandardCharsets.UTF_8);
    }


    //reading file line by line
    public void readLineByLine(String filename) throws URISyntaxException, IOException {
        final Stream<String> lines = Files.lines(Paths.get(getClass().getClassLoader().getResource("sample.txt").toURI()));
        lines.forEach(line -> System.out.println(line));
    }

    // reading file form specific path
    public String readFromSpecificPath(String path) throws IOException {
        final byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    //reading file using buffered reader
    public void readAsBufferedReader(String filename) throws IOException {
        final BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename));
        final Stream<String> lines = bufferedReader.lines();
        lines.forEach(line -> System.out.println(line));
    }


    //reading file old way using buffered reader
    public void oldWayBufferedReader(String path) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // reading file char by char  ( not preferred way to read file )
    public void inputStreamReader(String path) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(path));
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    //reading file using input stream
    public void bufferedInputStream(String path) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        PrintWriter printWriter = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(path)));
            printWriter = new PrintWriter(System.out);
            byte[] bytes = new byte[256];
            int n;
            while ((n = bufferedInputStream.read(bytes)) != -1) {
                printWriter.print(new String(bytes, StandardCharsets.UTF_8));
            }
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            FileUtil fileUtil = new FileUtil();
            // System.out.println(fileUtil.readFromResource("sample.txt"));
            //fileUtil.readLineByLine("sample.txt");
            // String content = fileUtil.readFromSpecificPath("C:\\Users\\Liju\\Documents\\gitprojects\\code-practice\\java-8\\src\\main\\resources\\sample.txt");
            // System.out.println(content);
            // fileUtil.oldWayBufferedReader("C:\\Users\\Liju\\Documents\\gitprojects\\code-practice\\java-8\\src\\main\\resources\\sample.txt");
            //fileUtil.inputStreamReader("C:\\Users\\Liju\\Documents\\gitprojects\\code-practice\\java-8\\src\\main\\resources\\sample.txt");
            fileUtil.bufferedInputStream("C:\\Users\\Liju\\Documents\\gitprojects\\code-practice\\java-8\\src\\main\\resources\\sample.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
