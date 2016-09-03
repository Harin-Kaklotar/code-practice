package com.lijubjohn.designpattern.structural.proxy;

/**
 * Created by liju on 8/30/16.
 */
public class Proxy {
}
// simple image interface
interface Image{
    public void displayImage();
}
// Real image
class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk(fileName);
    }
    private void loadImageFromDisk(String fileName) {
        System.out.printf("loading %s file from disk \n", fileName);
    }
    @Override
    public void displayImage() {
        System.out.println("displaying image - "+fileName);
    }
}
// Proxy image
class ProxyImage implements Image{
    private String fileName;
    private Image image;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    @Override public void displayImage() {
        if (image==null){
            image = new RealImage(fileName); // realImage - create once and reuse via proxy
        }
        image.displayImage(); // proxy call ( uses the same object )
    }
}
// Client class
class Client{
    public static void main(String[] args) {
        Image imageA = new ProxyImage("imageA");
        Image imageB = new ProxyImage("imageB");
        imageA.displayImage();
        imageA.displayImage();
        imageB.displayImage();
        imageB.displayImage();
    }
}