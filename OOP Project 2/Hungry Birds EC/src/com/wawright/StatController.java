package com.wawright;

public class StatController {
    public Double TotalDamageDealt;
    public int TotalTickCounter;
    public BirdController HighestDamageBird;
    public BirdController LowestDamageBird;
    public double damagemax,damagemin;

    public StatController( BirdController firstBirdIn) {
        TotalDamageDealt = 0.0;
        TotalTickCounter = 0;
        damagemax = -1;
        damagemin = -1;
        HighestDamageBird = firstBirdIn;
        LowestDamageBird = firstBirdIn;
    }
    public void processGameTick(TickController tickIn){
        if(damagemax==-1){
            damagemax = tickIn.damageDealt;
            damagemin = tickIn.damageDealt;
        }
        //increment tick counter
        TotalTickCounter++;
        //sum damage delt
        TotalDamageDealt += tickIn.damageDealt;
        //check birds damage and save
        if(tickIn.damageDealt>damagemax){
            HighestDamageBird = tickIn.currentBird;
            damagemax = tickIn.damageDealt;
        }
        if(tickIn.damageDealt<damagemin){
            LowestDamageBird = tickIn.currentBird;
            damagemin = tickIn.damageDealt;
        }
    }
}
