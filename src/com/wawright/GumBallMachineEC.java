//CS-225-L01_2021_10.US
//OOP Project 1
//Developed by william Wright 9/2/2020
package com.wawright;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GumBallMachineEC {
    //Use an array to hold the flavors.
    private final String[] GumballFlavors = {"Lime","Orange-Dreamsicle","Peach","Apple","Lemon"};
    // Add an extra array to your gum ball machine, and use it to pre-calculate the flavor of every gum ball ahead of time.
    private String[] GumballCalculated;
    //Global Gumball Counter
    private int GumballsRemaining;
    public GumBallMachineEC(int GumballInventory_In) {
        System.out.println("Creating new Extra Credit Gumball Machine with "+GumballInventory_In +" Gumballs");
        //pre-calculate the flavor of every gum ball ahead of time.
        GumballsRemaining = GumballInventory_In;
        precalculate(GumballInventory_In);
    }
    //pre-calculate the flavor of every gum ball ahead of time.
    private void precalculate(int GumballInventory_In){
        GumballCalculated = new String[GumballInventory_In];
        for(int i =0;i<GumballInventory_In;i++){
            //Get random flavor to fill gumball array
            int randomgumball = (int)(Math.random() * (GumballFlavors.length ));
            //fill each slot in the array with a random gumball from our flavor list
            GumballCalculated[i] = GumballFlavors[randomgumball];
        }
    }

    //Each time the user calls inventory() you will print the number of gum balls left in the machine.
    public void inventory() {
        System.out.println("Printing Gumball Machines Inventory");
        System.out.println("------------ Gumball inventory ------------");
        for(int i =0;i<GumballCalculated.length;i++){
            System.out.println("| "+ (i+1)+".) "+ GumballCalculated[i]);
        }
        System.out.println("--------------------------------------------\n");
    }
    //randomly shuffles the positions of the gum balls.
    public void shakeMachine() {
        //List inventory Before shuffling
        System.out.println("Gumballs Before Shuffle");
        for(int i =0;i<GumballCalculated.length;i++){
            System.out.println("| "+ (i+1)+".) "+ GumballCalculated[i]);
        }
        //change the gumball array into a String List
        List<String> GumList = Arrays.asList(GumballCalculated);
        //use built in shuffle function
        Collections.shuffle(GumList);
        //save List back to array
        GumballCalculated = GumList.toArray(new String[GumList.size()]);
        System.out.println("Gumballs Post Shuffle");
        for(int i =0;i<GumballCalculated.length;i++){
            System.out.println("| "+ (i+1)+".) "+ GumballCalculated[i]);
        }
    }
    //first available gum ball will be dispensed.
    // Do not re-use dispensed gum balls!
    public void insertCoin() {
        System.out.println("Gumball Machine Dispensing");
        //Check if their is any remaining gumballs
        if(GumballsRemaining==0){
            System.out.println("------------ Gumball InsertCoin ------------");
            System.out.println(" Gumball Machine Is SOLD OUT");
            System.out.println("--------------------------------------------\n");
        }else {
            //Dispense the first gumball in the Precalculated array
            System.out.println("------------ Gumball InsertCoin ------------");
            System.out.println(" Dispensing Gumball: " + GumballCalculated[0] + "");
            System.out.println("--------------------------------------------\n");
            //remove gumball at index 0 from array and resize array
            GumballCalculated = GumballArrayHelper(GumballCalculated);
            GumballsRemaining--;
        }
    }
    private String[] GumballArrayHelper(String[] oldGumArray){
        //make a new array with the size -1
        String[] NewGumarray = new String[oldGumArray.length-1];
        //copy over the index values excluding the first value
        for(int i =1;i<oldGumArray.length;i++){
            NewGumarray[i-1] = oldGumArray[i];
        }
        return NewGumarray;
    }
}