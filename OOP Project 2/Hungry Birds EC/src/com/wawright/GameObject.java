package com.wawright;

//Gameobject is reasonable for the management for the hungry birds game.
//This class will hold all of the variables to make the game run, this class will keep track of the ticks and handle the game logic.
//the user will be assigned a random amount of birds between 5-10 these birds will have different types of ability's.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameObject {

    //The Tower Object
    public TowerController gameTower;
    //The array List Containing the Birds
    public List<BirdController> gameBirdList;
    //The Statistics of the game
    public StatController gameStatistics;
    //Object to handle the current turn
    public TickController currentTick;
    //the random value for the birds
    private Random rand = new Random();
    //The default constructor will randomly create the game scene
    //1.) create a new Tower for the enemy to attack with a random amount of health
    //2.) Generate the random birds and store them in a arraylist
    public GameObject(){
        //Default tower with random health
        gameTower = new TowerController();
        //default random amount of random birds
        handleBirds();
        //default stat controller with objects passed in
        gameStatistics = new StatController(gameBirdList.get(0));
        //start the tick controller for handling game ticks
        currentTick = new TickController(gameTower,gameStatistics);
    }

    private void handleBirds(){
        gameBirdList = new ArrayList<BirdController>();
       int loop = rand.nextInt(10)+1;
        for(int i =0;i<loop;i++){
            gameBirdList.add(new BirdController(rand));
        }
    }

    public void tick(){
        //This method is called each time a bird is launched to calculate the damage and update the objects
        //Check win/null conditions
        if(gameBirdList.isEmpty()||gameTower.checkWin()){
           //user is out of birds or tower is destroyed.
            WinCondition();
        }else {
            //Get bird to launch and remove it from the array
            BirdController tempBird = gameBirdList.remove(0);
            //make the bird yell its favorite food
            tempBird.yell();
            //Calculate the tick
            currentTick.calculateGameTick(tempBird);
            //print information on the game tick
            print();

        }
    }
    //called when the user wins the game
    private void WinCondition(){
        //this trigger shouldn't fire ever its mainly for testing
        System.out.println("WinTriggered");
    }
    public void print(){
        //print basic information from each tick
        System.out.println("Tower Health: "+gameTower.towerHealthCurrent);
        System.out.println("Damage Dealt This tick: "+currentTick.damageDealt);
    }
    public void printbirds(){
        //print the total amount of birds generated and their stats
        System.out.println("|-Total Birds Generated: " +(gameBirdList.size()));
        for(int i=0;i< gameBirdList.size();i++){
            System.out.println("|--Bird "+(i + 1)+"\n|  -Damage Modifier: "+gameBirdList.get(i).RNG+"\n|  -Favorite food: "+gameBirdList.get(i).favoriteFood);
        }
    }
    public void printTower(){
        System.out.println("|-Tower Starting Health: "+gameTower.towerHealthTotal);
        System.out.println("|-Tower current Health:  "+gameTower.towerHealthCurrent +" " + gameTower.towerHealthPercentage+"% Health Remaining");
    }
}
