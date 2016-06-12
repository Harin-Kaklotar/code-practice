package composite;

/**
 * Created by liju on 5/24/16.
 */
//component class
public class File extends AbstractFile {

    public File(String name){
        super(name);
    }

    @Override public void ls() {
        System.out.println("\t" +super.name);
    }
}
