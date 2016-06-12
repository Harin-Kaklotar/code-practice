package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 5/24/16.
 */

//composite class -- composes file component
public class Directory extends AbstractFile {

    private List<AbstractFile> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void add(AbstractFile file){
        files.add(file);
    }

    @Override
    public void ls() {
        System.out.println(super.name);
        files.forEach(AbstractFile::ls);
    }
}
