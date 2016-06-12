package composite;

/**
 * Created by liju on 5/24/16.
 */

// contain common methods for component and composite classes
public abstract class AbstractFile {
    protected String name;

    public AbstractFile(String name) {
        this.name = name;
    }

    public abstract void ls();

}
