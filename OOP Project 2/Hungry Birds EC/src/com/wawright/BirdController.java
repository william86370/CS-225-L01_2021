package com.wawright;

import java.util.Random;

public class BirdController {

    public String favoriteFood;
    public double RNG;
    private Random rand = new Random();
    private String[] Favfoodrandom = {"watermelon","cherry","Grapes","Salad","FishandChips","Orange Chicken","Apples","Banana"};
    public BirdController(){
        favoriteFood = "food";
        RNG = rand.nextInt(100);
    }
    public BirdController(String favfood){
        favoriteFood = favfood;
        RNG = rand.nextInt(100);
    }
    public BirdController(Random randin){
        favoriteFood = Favfoodrandom[randin.nextInt(Favfoodrandom.length-1)];
        RNG = rand.nextInt(100);
    }

    public void yell() {
        System.out.println(favoriteFood);
    }
    public void yell(String favWord) {
        System.out.println(favWord);
    }

}

