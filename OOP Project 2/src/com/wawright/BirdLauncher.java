package com.wawright;

import java.util.List;

public class BirdLauncher {
    List<Bird> birds;
    public BirdLauncher(List<Bird> birds) {
        this.birds=birds;
    }

    public void launch() {
        for (Bird bird : birds) {
            bird.yell();
        }
    }

    public void launch(String salad) {
        for (Bird bird : birds) {
            bird.yell(salad);
        }
    }
}
