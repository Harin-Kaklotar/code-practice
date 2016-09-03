package com.lijubjohn.designpattern.behavioral.state;

/**
 * Created by liju on 8/29/16.
 */
public class State {
}

// Simple player of a game
class Player{
    public void attack(){
        System.out.println("player attacking");
    }
    public void fireBullets(){
        System.out.println("player firing");
    }
    public void defend(){
        System.out.println("player defending");
    }
    public void askHelp(){
        System.out.println("Help me out");
    }
    public void dead(){
        System.out.println("player is dead");
    }
}
//simple state of player
interface PlayerState{
    public void action(Player player);
}
// different implementation of state   - Healthy ,Survival or Dead ( states of player)
class HealthyState implements PlayerState{
    @Override public void action(Player player) {
        player.attack();
        player.fireBullets();
    }
}
class SurvivalState implements PlayerState{
    @Override public void action(Player player) {
        player.defend();
        player.askHelp();
    }
}
class DeadState implements PlayerState{
    @Override public void action(Player player) {
        player.dead();
    }
}
// Context object  - the behavior of context varies as the state changes
class GameContext {
    private PlayerState playerState;
    private Player player;

    public GameContext(PlayerState playerState, Player player) {
        this.playerState = playerState;
        this.player = player;
    }
    public void gameAction(){
        playerState.action(player);
    }
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }
}
// Client class
class Client{
    public static void main(String[] args) {
        GameContext gameContext  = new GameContext(new HealthyState(),new Player());
        gameContext.gameAction();
        gameContext.setPlayerState(new SurvivalState());
        gameContext.gameAction();
    }
}