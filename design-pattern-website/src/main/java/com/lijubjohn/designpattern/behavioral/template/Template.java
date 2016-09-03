package com.lijubjohn.designpattern.behavioral.template;

/**
 * Created by liju on 8/29/16.
 */
public class Template {
}

//abstract class which defines the template method
abstract class DocumentGenerator {

    protected abstract void addHeader();

    protected abstract void addFooter();

    protected abstract void addBody();

    // template method , common to all subclasses , no class overrides it
    protected final void generateDocument() {
        addHeader();
        addBody();
        addFooter();
    }
}
// one of the implementation of Document generator
class HTMLDocumentGenerator extends DocumentGenerator {
    @Override
    public void addHeader() {
        System.out.println("adding html header");
    }
    @Override
    public void addFooter() {
        System.out.println("adding html footer");
    }
    @Override
    public void addBody() {
        System.out.println("adding html body");
    }
}

// another implementation of Document generator
class PDFDocumentGenerator extends DocumentGenerator {
    @Override
    public void addHeader() {
        System.out.println("adding pdf header");
    }
    @Override
    public void addFooter() {
        System.out.println("adding pdf footer");
    }
    @Override
    public void addBody() {
        System.out.println("adding pdf body");
    }
}
//Client class
class Client {
    public static void main(String[] args) {
        DocumentGenerator documentGenerator = new HTMLDocumentGenerator(); //HTMLDocument
        documentGenerator.generateDocument();// template method
        documentGenerator = new PDFDocumentGenerator(); //PDFDocument
        documentGenerator.generateDocument();// template method
    }
}
