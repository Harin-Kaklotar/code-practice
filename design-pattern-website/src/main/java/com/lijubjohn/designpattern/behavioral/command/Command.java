package com.lijubjohn.designpattern.behavioral.command;

/**
 * Created by Liju on 8/25/2016.
 */

// Command interface
public interface Command {
    void execute();
}

// Receiver object
class Light {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

// Command implementation (note  - the command contains the receiving object)
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

//another command implementation
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class SimpleRemote {
    Command slot; // one slot for this remote

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonPressed() {
        slot.execute();// execute the command stored in this slot
    }
}

class Client {
    public static void main(String[] args) {
        //Light is the receiver of command request
        Light light = new Light();
        //Command
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        //SimpleRemote is the invoker , it will be passed a command object that can be used to make request
        SimpleRemote simpleRemote = new SimpleRemote();
        simpleRemote.setCommand(lightOnCommand);
        simpleRemote.buttonPressed();
    }
}