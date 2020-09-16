package com.wawright;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tempscan = new Scanner(System.in);
        //Creating values and setting up the game
        GameObject game = setupMenu();
        //Run game logic until an exit condition is reached
        //1.) the user will run out of birds
        //2.) the user will kill the tower
        boolean TempGamewin =false;
        do{
        //prompt the user for Selection
            //clearScreen();
            //win condition not met Their must be a bird?
            BirdController tempBird = game.gameBirdList.get(0);
            System.out.println("A Bird is Ready to fire!!\n\nBird Stats:\n-Favorite Food: "+tempBird.favoriteFood+"\n-Bird Damage Modifier: "+tempBird.RNG);
            System.out.print("Fire Bird? Y/N: ");
            String userChoice1 = tempscan.next();
            //im lazy so force upper for condition check
            userChoice1 = userChoice1.toUpperCase();
            if(!userChoice1.equals("Y")) { System.out.print("Why Not????: ill launch the bird for you then!!"); }
            //User has chosen to launch the bird
            //Send game tick and run all condition methods
            game.tick();
            //Check for Win conditions because the while condition is busted broken
            if(game.gameBirdList.isEmpty()||game.gameTower.towerHealthCurrent <=0){
                TempGamewin = true;
            }
            System.out.println("Enter any key To continue........");
            tempscan.next();
        }while(!TempGamewin);//Check for Win condition
        //The Game should be at a win condition? Maybe...
        //Check what condition the game ended on
        if(game.gameBirdList.isEmpty()){//The User has used all of their Birds User Fails
            System.out.println("You Have run out Of Birds and the tower wasn't destroyed :(");
        }else{//Win Condition
            System.out.println("You Have Destroyed the Tower :)");
        }
        //print all game stats
        System.out.println("Game Statistics");
        System.out.println("-Number of Ticks: "+ game.gameStatistics.TotalTickCounter );
        System.out.println("-Total Damage Dealt to tower : "+ game.gameStatistics.TotalDamageDealt );
        System.out.println("-Highest Damage : "+ game.gameStatistics.damagemax+"\n--By Bird With Favorite Food: " + game.gameStatistics.HighestDamageBird.favoriteFood +" and RNG: "+ game.gameStatistics.HighestDamageBird.RNG );
        System.out.println("-Lowest Damage : "+ game.gameStatistics.damagemin+"\n--By Bird With Favorite Food: " + game.gameStatistics.LowestDamageBird.favoriteFood +" and RNG: "+ game.gameStatistics.LowestDamageBird.RNG );
        System.out.println("-Tower Health: "+ game.gameTower.towerHealthTotal);
    }

    public static GameObject setupMenu(){
        GameObject game = new GameObject();
        Scanner tempscan = new Scanner(System.in);
        //clear the screen
        clearScreen();
        //Main Menu
        System.out.println("|------------- Hungry Birds V1 -------------|");
        System.out.println("|                   CS-220                  |");
        System.out.println("|               William Wright              |");
        System.out.println("|-------------------------------------------|");
        //wait for user input to start the game
        System.out.println("Enter any key To Start........");
        tempscan.next();
        //clear the screen
        clearScreen();
        //start the loop for bird selection
        String tempchoice1;
        do{
            game = new GameObject();
            System.out.println("|--------------------------- Game Setup ---------------------------|");
            System.out.println("|                                                                  |");
            System.out.println("|                Randomly Generating Birds and Tower               |");
            System.out.println("|                       Printing Settings...                       |");
            System.out.println("|                                                                  |");
            System.out.println("|------------------------------------------------------------------|\n");
            System.out.println("|------------------------------------------------------------------|");
            System.out.println("|                        New Game Settings                         ");
            game.printTower();
            game.printbirds();
            System.out.println("|------------------------------------------------------------------|");
            System.out.print("\n Start Game with These Settings Y/N: ");
            tempchoice1 = tempscan.next();
            //im lazy so force upper for condition check
            tempchoice1 = tempchoice1.toUpperCase();
        }while(!tempchoice1.equals("Y"));
        return game;
    }
    public static void clearScreen(){
        for(int i=0;i<100;i++){
            System.out.println();
        }
    }
}
