package com.lijubjohn.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;
//dummy class
public class Composite {
}


abstract class AbstractFile {
    protected String filename;

    protected AbstractFile(String filename) {
        this.filename = filename;
    }

    /* method to list file names */
    public abstract void ls();
}

// Leaf
class File extends AbstractFile {
    public File(String filename) {
        super(filename);
    }

    @Override
    public void ls() {
        System.out.println(filename);
    }
}

// Composite , collection of leaves
class Directory extends AbstractFile {
    private List<AbstractFile> files = new ArrayList<>();

    public Directory(String filename) {
        super(filename);
    }

    public void addFile(AbstractFile file) {
        files.add(file);
    }

    @Override
    public void ls() {
        System.out.println(super.filename);
        files.forEach(AbstractFile::ls);
    }
}
// Client
class Client {
    public static void main(String[] args) {
        File fileA = new File("File A");
        File fileB = new File("File B");
        Directory dir = new Directory("Dir A");
        dir.addFile(fileA);
        dir.addFile(fileB);
        dir.ls();
    }
}
