package composite;

/**
 * Created by liju on 5/24/16.
 */
public class App {

    public static void main(String[] args) {
        Directory dir1 = new Directory("Dir1");
        Directory dir2 = new Directory("Dir2");
        Directory dir3 = new Directory("Dir3");

        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");
        File file5 = new File("file5");

        dir1.add(file1);

        dir2.add(dir1);
        dir2.add(file3);

        dir3.add(file3);
        dir3.add(file4);
        dir3.add(dir2);

        dir3.ls();
    }
}
