package com.lijubjohn.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liju on 8/25/2016.
 */


abstract class User {
    protected Mediator mediator;
    protected String userName;

    public User(Mediator mediator, String userName) {
        this.mediator = mediator;
        this.userName = userName;
    }

    // broadcast message to other users via mediator
    public void send(String msg) {
        mediator.send(msg, this);
        System.out.println(userName + " : msg sent : msg - " + msg);
    }

    // receive message
    abstract public void receive(String msg);
}

class UserImpl extends User {
    public UserImpl(Mediator mediator, String userName) {
        super(mediator, userName);
    }

    @Override
    public void receive(String msg) {
        System.out.println(userName + " : msg received : msg - " + msg);
    }
}

/* Simple msg broadcaster using mediator
   It broad message to all the users except the originator
*/
class Mediator {
    List<User> users = new ArrayList<>();

    public void send(String msg, User user) {
        users.stream().filter(x -> x != user).forEach(x -> x.receive(msg));
    }

    public void addUser(User user) {
        users.add(user);
    }
}

class Client {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        UserImpl userA = new UserImpl(mediator, "User A");
        UserImpl userB = new UserImpl(mediator, "User B");
        UserImpl userC = new UserImpl(mediator, "User C");
        mediator.addUser(userA);
        mediator.addUser(userB);
        mediator.addUser(userC);

        userA.send("Hello world");
    }
}
