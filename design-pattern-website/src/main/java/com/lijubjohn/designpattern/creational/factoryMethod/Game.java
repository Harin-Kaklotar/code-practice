package com.lijubjohn.designpattern.creational.factoryMethod;

/**
 * Created by liju on 8/22/16.
 */
public abstract class Game {
    public abstract IArmy createArmy();
    public abstract ICastle createCastle();
    public abstract IEnemy createEnemy();
    public void configureGame(){
        final IArmy army = createArmy();//createCastle() // createMap() // createEnemy()
        //do all the game related configuration using , instantiation is deferred to derived classes
    }
}

interface IArmy {
    public void renderArmy();
}

interface ICastle{
    public void renderCastle();
}

interface IEnemy{
    public void renderEnemy();
}

class SimpleGame extends Game{
    @Override public IArmy createArmy() {
        return null; //return your simple army
    }

    @Override public ICastle createCastle() {
        return null;//return your simple castle
    }

    @Override public IEnemy createEnemy() {
        return null;//return your simple enemy
    }
    //common functionality of configuring the game is contained in the base class and is reused by all derived class
}

class Client{
    public static void main(String[] args) {
        new SimpleGame().configureGame();
    }
}