package com.wawright;

import java.util.Random;

//TickController is responsible for processing the current game tick
//this object will receive all the information in and process the results.
//this object will be passed around.
public class TickController {
    //These objects are passed in
    private TowerController gameTower;
    //The Statistics of the game
    private StatController gameStatistics;
    //The random RNG Generater
    private Random rand = new Random();
    //These objects are Calculated using the others
    public double damageDealt,damageBefore,damageAfter;//This Ticks Damage to the Tower
    public double birdDamageModifier;//the bird's damage modifier calculated from the Bird Type and Bird's Tier
    public BirdController currentBird;
    //Constructor takes the GameTowers as a parameter
    public TickController(TowerController gameTower, StatController gameStatistics){
        this.gameTower = gameTower;
        this.gameStatistics = gameStatistics;
    }

    //Method Takes in the Current GameTower
    public void calculateGameTick(BirdController currentBirdIn){
        //set the bird we are working with
        currentBird = currentBirdIn;
        //calculate damage from the bird and apply to the tower
        damageBefore = gameTower.towerHealthCurrent;
        birdDamageModifier = rand.nextInt(100);
        damageDealt = currentBirdIn.RNG * birdDamageModifier;
        damageAfter = damageBefore - damageDealt;
        //Save the new info to the tower
        gameTower.applyDamage(damageDealt);
        //Process the Stats tick passing in this class for data values
        //basally passing pointer values
        gameStatistics.processGameTick(this);
        //process the new tower stats
        gameTower.calculateGameTick();
    }


}
