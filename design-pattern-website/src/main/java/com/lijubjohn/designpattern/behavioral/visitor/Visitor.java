package com.lijubjohn.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 8/29/16.
 */

//Visitable interface
interface Visitable{
    public void accept(Visitor visitor);
}
// Implementation of visitable
class Book implements Visitable{
    private double price,wgt;

    public Book(double price, double wgt) {
        this.price = price;
        this.wgt = wgt;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public double getPrice() {
        return price;
    }
    public double getWgt() {
        return wgt;
    }
}
// Implementation of visitable
class DVD implements  Visitable{
    private double price,wgt;

    public DVD(double price, double wgt) {
        this.price = price;
        this.wgt = wgt;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public double getPrice() {
        return price;
    }
    public double getWgt() {
        return wgt;
    }
}

//Visitor interface
public interface Visitor {
    public void visit(Book book);
    public void visit(DVD dvd);
}
//Visitor implementation (calculates postal service cost)
class PostageVisitor implements Visitor{
    private double totalPostageCost;

    @Override
    public void visit(Book book) {
        //add postage cost if book price is less than 50
        if (book.getPrice() < 50){
            totalPostageCost += book.getWgt() *0.1;
        }
    }
    @Override
    public void visit(DVD dvd) {
        //add postage cost if dvd price is less than 20
        if (dvd.getPrice() < 20){
            totalPostageCost += dvd.getWgt() *0.3;
        }
    }
    //return total postage cost
    public Double getTotalPostageCost() {
        return totalPostageCost;
    }
}
//Client class
class Client{
    public static void main(String[] args) {
        PostageVisitor postageVisitor = new PostageVisitor();
        List<Visitable> visitables = new ArrayList<>();
        visitables.add(new Book(10,12));
        visitables.add(new DVD(5,20));
        visitables.stream().forEach(visitable -> visitable.accept(postageVisitor));
        System.out.println(postageVisitor.getTotalPostageCost());
    }
}
