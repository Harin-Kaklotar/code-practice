package com.lijubjohn.designpattern.creational.factoryMethod;

/**
 * Created by liju on 8/22/16.
 */
public abstract class Game {
    public abstract IArmy createArmy();

    public abstract ICastle createCastle();

    public abstract IEnemy createEnemy();

    public void configureGame() {
        final IArmy army = createArmy();
        final ICastle castle = createCastle();
        final IEnemy enemy = createEnemy();
        //do all the game related configuration using , instantiation is deferred to derived classes
    }
}

interface IArmy {
    void renderArmy();
}

interface ICastle {
    void renderCastle();
}

interface IEnemy {
    void renderEnemy();
}

class SimpleGame extends Game {
    @Override
    public IArmy createArmy() {
        return null; //return your simple army , intentionally un-implemented
    }

    @Override
    public ICastle createCastle() {
        return null;//return your simple castle , intentionally un-implemented
    }

    @Override
    public IEnemy createEnemy() {
        return null;//return your simple enemy , intentionally un-implemented
    }
    //common functionality of configuring the game is contained in the base class and is reused by all derived class
}

class Client {
    public static void main(String[] args) {
        new SimpleGame().configureGame();
    }
}