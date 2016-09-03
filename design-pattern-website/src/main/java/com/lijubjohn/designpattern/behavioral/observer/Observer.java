package com.lijubjohn.designpattern.behavioral.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by liju on 8/29/16.
 */
// observer of type T
public interface Observer<T> {
    public void notify(T a);
}

// observer of type T
abstract class Observable<T>{
    private List<Observer> observers;

    public Observable() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }
    public void unSubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notify(T argument){
        observers.stream().forEach( observer  -> observer.notify(argument));
    }
}

enum Attack{ ARROW,GUN,BOMB}
//Different Observers of type attack
class ArrowObserver implements Observer<Attack>{
    @Override
    public void notify(Attack attack) {
     if (attack.equals(Attack.ARROW)){
         System.out.println("ArrowObserver : defend arrow");
     }else{
         System.out.printf("ArrowObserver : %s can't kill me \n" ,attack);
     }
    }
}
class GunObserver implements Observer<Attack>{
    @Override
    public void notify(Attack attack) {
        if (attack.equals(Attack.GUN)){
            System.out.println("GunObserver : defend bullets");
        }else {
            System.out.printf("GunObserver : %s can't kill me \n", attack);
        }
    }
}
class BombObserver implements Observer<Attack>{
    @Override
    public void notify(Attack attack) {
        if (attack.equals(Attack.BOMB)){
            System.out.println("BombObserver : defend bomb");
        }else {
            System.out.printf("BombObserver : %s can't kill me \n", attack);
        }
    }
}
//concrete Observable
class AttackObservable extends Observable<Attack>{

}
//Client
class Client {
    public static void main(String[] args) {
        AttackObservable attackObservable = new AttackObservable();
        attackObservable.subscribe(new ArrowObserver());
        attackObservable.subscribe(new GunObserver());
        attackObservable.subscribe(new BombObserver());
        attackObservable.notify(Attack.ARROW);
    }
}







