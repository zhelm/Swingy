package com.swingy.Controller;

import com.swingy.Model.HeroFactory;
import com.swingy.Model.HeroModel;
import com.swingy.View.Map;

public class GameController {
    
    Map map;
    HeroModel Hero;
    public GameController() {
        this.getNewHero();
        map = new Map(Hero);
        this.displayMap();
        System.out.println(map.getCenter());
        Hero.gainLevel();
        this.displayMap();
    }
    
    public void getNewHero() {
        this.Hero = HeroFactory.getNewHero("null");
    }

    // Create/Select Hero
    public void displayMap() {
        String[][] display = map.getMap();
    }





// Update Hero(Model)
// Movement
// Update position(View)
    
}