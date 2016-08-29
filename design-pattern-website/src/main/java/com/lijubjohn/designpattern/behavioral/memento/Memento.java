package com.lijubjohn.designpattern.behavioral.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 8/29/16.
 */
//a memento represents an internal state of the originator at a given point of time
public class Memento {
    private int x,y;  // for representing state of originator

    public Memento(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //getter and setter for x,y
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}

/* Originator uses memento object as snapshot for storing its internal state at any point of time
   Using caretaker it can restore to one of its previous state.
   In this example Originator can be thought of tracking a moving 2d point and hence have (x,y) coordinates as state
*/
class Originator{
    private int x,y;
    private Caretaker caretaker;
    private String lastSavePoint;
    public Originator(int x, int y,Caretaker caretaker) {
        this.x = x;
        this.y = y;
        this.caretaker= caretaker;
        createSavePoint("Default");//mark initial save point as default
    }
    //creates a savepoint
    public void createSavePoint(String savePoint){
        caretaker.saveMemento(savePoint,new Memento(this.x,this.y));
        lastSavePoint = savePoint;
    }

    //go to last save point
    public void undo(){
        gotoSavePoint(this.lastSavePoint);
    }
    //go to a particular savepoint
    public void gotoSavePoint(String savePoint){
        final Memento memento = caretaker.getMemento(savePoint);
        this.x = memento.getX();
        this.y = memento.getY();
    }
    //clear all save points
    public void clearSavePoints(){
        gotoSavePoint("Default");//revert to initial save point
        caretaker.clearSavePoints();
    }

    // show current state
    public void show(){
        System.out.printf("x=%d , y=%d \n", x, y);
    }

    //getter and setter for x and y
    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}

//does all the book-keeping of memento objects , doesn't care about internals of memento object
class Caretaker{
    private Map<String,Memento> savePoints  = new HashMap<>();
    //save point for a memento
    public void saveMemento(String savePoint, Memento memento){
        savePoints.put(savePoint,memento);
    }
    //get memento associated with given save point
    public Memento getMemento(String savePoint){
        return savePoints.get(savePoint);
    }
    //clear all save points
    public void clearSavePoints(){
        savePoints.clear();
    }
}

class Client{
    public static void main(String[] args) {
        Originator originator = new Originator(10,20,new Caretaker());
        originator.show();
        originator.setX(11);originator.setY(21);
        originator.createSavePoint("Save point 1");
        originator.setX(12);originator.setY(22);
        originator.show();
        originator.gotoSavePoint("Save point 1");
        originator.show();
        originator.clearSavePoints();
        originator.show();
    }
}
