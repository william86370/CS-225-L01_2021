package com.wawright;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Bird());
        birds.add(new PizzaBird());
        birds.add(new IceCreamBird());
        BirdLauncher launcher = new BirdLauncher(birds);
        launcher.launch(); // food, pizza, ice cream
        launcher.launch("salad"); // salad, salad, salad
    }
}
