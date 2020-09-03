//CS-225-L01_2021_10.US
//OOP Project 1
//Developed by william Wright 9/2/2020
package com.wawright.OOPProject1;

public class GumBallMachine {
    //Use an array to hold the flavors.
    private final String[] GumballFlavors = {"Cherry","Lemon","Watermelon"};
    private int GumballInventory = 0;
    public GumBallMachine(int GumballInventory_In) {
        System.out.println("Creating new Gumball Machine with "+GumballInventory_In +" Gumballs");
        GumballInventory = GumballInventory_In;
    }

    //Each time the user calls inventory() you will print the number of gum balls left in the machine.
    public void inventory() {
        System.out.println("Printing Gumball Machines Inventory");
        System.out.println("------------ Gumball inventory ------------");
        System.out.println(" Gumballs Remaining: "+GumballInventory+ "");
        System.out.println("--------------------------------------------\n");
    }

    // Your gum ball machine will have at least 3 different flavors
// (e.g. cherry, lemon, etc). You will dispense a random flavor each time the user calls insertCoin().
// If the machine is out of gum balls, you will print SOLD OUT
    public void insertCoin() {
        System.out.println("Gumball Machine Dispensing");
        //Check if their is any remaining gumballs
        if(GumballInventory<1){
            System.out.println("------------ Gumball InsertCoin ------------");
            System.out.println(" Gumball Machine Is SOLD OUT");
            System.out.println("--------------------------------------------\n");
        }else {
            //create new random value from 0-GumballFlavors.length()
            int randomgumball = (int)(Math.random() * (GumballFlavors.length ));
            System.out.println("------------ Gumball InsertCoin ------------");
            System.out.println(" Dispensing Gumball: " + GumballFlavors[randomgumball] + "");
            System.out.println("--------------------------------------------\n");
            //decrement Global Gumball inventory Value
            GumballInventory--;
        }
    }
}