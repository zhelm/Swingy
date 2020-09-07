package com.swingy.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import com.swingy.Model.HeroFactory;
import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainFactory;
import com.swingy.Model.VillainModel;
import com.swingy.View.Map;

public class GameController {

    boolean winRound;

    Method method;
    private ArrayList<VillainModel> observer = new ArrayList<VillainModel>();

    Map map;
    HeroModel Hero;

    public GameController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        this.getNewHero();
        map = new Map(Hero, getVillains());
        String line;
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("Exit")) {
            System.out.println("Say something");

            if (!line.equals("North") && !line.equals("West") && !line.equals("East") && !line.equals("South")
                    && !line.equals("")) {
                System.out.println("Please enter a correct message and not: " + line);
            } else {
                line = "move" + line;
                method = Hero.getClass().getMethod(line);
                winRound = (boolean) method.invoke(Hero);
                System.out.println(winRound);
                
                displayMap();
                if(winRound == true) {
                    map = new Map(Hero, getVillains());
                    winRound = false;
                }

                // Todo move/add villains. if hero xp 0 then generate based on level except if
                // hero level 0(specific issue). move after each move
            }
        }
        scanner.close();

    }

    public void getNewHero() {
        this.Hero = HeroFactory.getNewHero("null");
    }
    public ArrayList<VillainModel> getVillains() {
        return VillainFactory.getVillains(Hero.getLevel());
    }

    // Create/Select Hero
    public void displayMap() {
        map.getMap();
    }

    public void moveHeroNorth() {
        Hero.moveNorth();
    }

    // Update Hero(Model)
    // Movement
    // Update position(View)

}