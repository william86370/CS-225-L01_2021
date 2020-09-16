package com.wawright;

import java.util.Random;

public class TowerController {
    public double towerHealthTotal;
    public double towerHealthCurrent;
    public int towerHealthPercentage;
    private Random rand = new Random();

    public TowerController(){
        towerHealthTotal = rand.nextInt(10000);
        towerHealthCurrent = towerHealthTotal;
        calculateGameTick();
    }
    public TowerController (int startingHealth){
        towerHealthTotal = startingHealth;
        calculateGameTick();
    }

    public void calculateGameTick(){
        towerHealthPercentage = (int) ((towerHealthCurrent/towerHealthTotal)*100);
    }
    public boolean checkWin(){
        return (towerHealthTotal<=0);
    }

    public void applyDamage(double damageDealt) {
        towerHealthCurrent -= damageDealt;
    }
}
