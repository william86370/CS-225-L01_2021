//CS-225-L01_2021_10.US
//OOP Project 1
//Developed by william Wright 9/2/2020
package com.wawright.OOPProject1;

public class Main {
    public static void main(String[] args) {

        //Create new Gumball Machine with 2 Gumballs
        GumBallMachine machine = new GumBallMachine(2);
        //print Gumball Machines Inventory
        machine.inventory();
        //Call Gumball Machine insertCoin()
        machine.insertCoin();
        //Call Gumball Machine insertCoin()
        machine.insertCoin();
        //Call Gumball Machine insertCoin()
        machine.insertCoin();
        //print Gumball Machines Inventory
        machine.inventory();

        //Start extra credit
        GumBallMachineEC machine2 = new GumBallMachineEC(10);
        //print Gumball Machines Inventory
        machine2.inventory();
        //Call Gumball Machine insertCoin()
        machine2.insertCoin();
        //Call Shake Machine
        machine2.shakeMachine();
        //Call Gumball Machine insertCoin()
        machine2.insertCoin();

    }
}