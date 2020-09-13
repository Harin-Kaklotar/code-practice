package lambda;

import java.io.File;
import java.io.FileFilter;

public class SyntaxTest {

    public static void main(String[] args) {
        File directoryPath = new File("/xyz");
        File[] result = directoryPath.listFiles(s -> s.getName().endsWith(".java"));
        //result = directoryPath.listFiles(s -> return s.getName().endsWith(".java")); //--> incorrect
        result = directoryPath.listFiles(s -> {return s.getName().endsWith(".java");} );
        // result = directoryPath.listFiles(s -> { s.getName().endsWith(".java");} ); // --> incorrect
        result = directoryPath.listFiles((File s) -> s.getName().endsWith(".java") );
    }
}

class FileFilterApplication {
    //method - starting
    public static void main(String[] args) {
        File directoryPath = new File("/xyz");

        File[] result = directoryPath.listFiles(new FileFilter() {

            public boolean accept(File filePathname) {
                return filePathname.getName().endsWith(".java");
            }
        });

        for(File file: result ){
            System.out.println(file.getName());
        }
    }
}