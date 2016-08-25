package com.lijubjohn.designpattern.structural.flyweight;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liju on 8/24/16.
 */
public class Flyweight {
}

// instance of Coffee flavour will be flyweights
class CoffeeFlavour {
    private String flavour;

    public CoffeeFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return flavour;
    }
}

class Menu {
    private Map<String, CoffeeFlavour> coffeeFlavours = new ConcurrentHashMap<>();

    /* here is the flyweight pattern , instead of constructing CoffeeFlavour for every request,
     we are constructing one time and caching it.
    */
    public CoffeeFlavour lookup(String flavour) {
        if (!coffeeFlavours.containsKey(flavour)) {
            coffeeFlavours.put(flavour, new CoffeeFlavour(flavour));
        }
        return coffeeFlavours.get(flavour);
    }
}

class Order {
    private int tableNumber;
    private CoffeeFlavour flavour;

    public Order(int tableNumber, CoffeeFlavour flavour) {
        this.tableNumber = tableNumber;
        this.flavour = flavour;
    }

    public void serveCoffee() {
        System.out.printf("serving coffee flavour %s to table number %d \n", flavour.toString(), tableNumber);
    }
}

class CoffeeShop {
    private List<Order> orderList = new ArrayList<>();
    private Menu menu = new Menu();

    public void takeOrders(String flavour, int table) {
        final CoffeeFlavour coffeeFlavour = menu.lookup(flavour);
        Order order = new Order(table, coffeeFlavour);
        orderList.add(order);

    }

    public void serveOrders() {
        orderList.forEach(Order::serveCoffee);
    }
}

class Client {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.takeOrders("Flavour A", 1);
        coffeeShop.takeOrders("Flavour B", 2);
        coffeeShop.takeOrders("Flavour C", 3);
        coffeeShop.serveOrders();
    }
}