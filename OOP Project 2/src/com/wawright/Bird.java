package com.wawright;

public class Bird {

    String favoriteFood;

    public Bird(){
        favoriteFood = "food";
    }

    public void yell() {
            System.out.println(favoriteFood);
    }
    public void yell(String favWord) {
        System.out.println(favWord);
    }

}
