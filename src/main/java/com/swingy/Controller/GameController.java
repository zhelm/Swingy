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
        Hero.moveNorth();
        System.out.println(map.getCenter());
        this.displayMap();
        System.out.println();
        this.Hero.moveWest();
        this.Hero.moveWest();
        this.displayMap();
    }
    
    public void getNewHero() {
        this.Hero = HeroFactory.getNewHero("null");
    }

    // Create/Select Hero
    public void displayMap() {
        String[][] display = map.getMap();
    }

    public void moveHeroNorth() {
        Hero.moveNorth();
    }





// Update Hero(Model)
// Movement
// Update position(View)
    
}