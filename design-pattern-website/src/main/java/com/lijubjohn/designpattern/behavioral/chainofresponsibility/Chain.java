package com.lijubjohn.designpattern.behavioral.chainofresponsibility;

/**
 * Created by Liju on 8/24/2016.
 */
public class Chain {
}
/* abstract class construct for  creating chain of AtmDispenser
   Note - it encapsulates AtmDispener itself ,which holds instance next AtmDispenser in the chain
*/
abstract class AtmDispenser {
    private AtmDispenser next;

    protected AtmDispenser(AtmDispenser atmDispenser){
        this.next = atmDispenser;
    }
    protected void dispense(int amount){
        if (next!=null){
            next.dispense(amount);
        }
    }
}

// responsible to dispense notes of $10 denomination
class TenDollarDispenser extends AtmDispenser{
    public TenDollarDispenser(AtmDispenser atmDispenser) {
        super(atmDispenser);
    }

    @Override
    protected void dispense(int amount) {
        int remaingAmount = amount;
        if (amount >= 10){
            int dispense  = remaingAmount / 10 ;
            remaingAmount = remaingAmount % 10;
            System.out.printf("dispensing %d  notes of $10 \n",dispense);
        }
        super.dispense(remaingAmount);
    }
}
// responsible to dispense notes of $5 denomination
class FiveDollarDispenser extends AtmDispenser{
    public FiveDollarDispenser(AtmDispenser atmDispenser) {
        super(atmDispenser);
    }

    @Override
    protected void dispense(int amount) {
        int remaingAmount = amount;
        if (amount >= 5){
            int dispense  = remaingAmount / 5 ;
            remaingAmount = remaingAmount % 5;
            System.out.printf("dispensing %d  notes of $5 \n",dispense);
        }
        super.dispense(remaingAmount);
    }
}
// responsible to dispense notes of $1 denomination
class OneDollarDispenser extends AtmDispenser{
    public OneDollarDispenser(AtmDispenser atmDispenser) {
        super(atmDispenser);
    }

    @Override
    protected void dispense(int amount) {
        int remaingAmount = amount;
        if (amount >= 1){
            int dispense  = remaingAmount / 1 ;
            remaingAmount = remaingAmount % 1;
            System.out.printf("dispensing %d  notes of $1 \n",dispense);
        }
        super.dispense(remaingAmount);
    }
}

class Client {
    public static void main(String[] args) {
        /*Creating a chain  of Atm dispenser which dispenses in denomination of $1, $5 and $10*/
        AtmDispenser atmDispenser = new TenDollarDispenser(new FiveDollarDispenser(new OneDollarDispenser(null)));
        //dispense amount
        atmDispenser.dispense(37);
    }
}
