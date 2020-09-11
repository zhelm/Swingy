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
    private ArrayList<VillainModel> Villains = new ArrayList<VillainModel>();

    Map map;
    HeroModel Hero;

    public GameController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        this.getNewHero();
        this.getVillains();

        map = new Map(Hero, Villains);

        String line;
        Scanner scanner = new Scanner(System.in);
        displayMap();
        while (!(line = scanner.nextLine()).equals("Exit")) {
            System.out.println("Say something");

            if (!line.equals("North") && !line.equals("West") && !line.equals("East") && !line.equals("South")
            && !line.equals("")) {
                System.out.println("Please enter a correct message and not: " + line);
            } else {
                winRound = Hero.coordinates.moveDirection(line, Villains);
                System.out.println(winRound);
                
                if(winRound == true) {
                    Hero.gainExperience();
                    this.getVillains();
                    map = new Map(Hero, Villains);
                    winRound = false;
                } else {
                    VillainController.moveVillains(Villains, Hero);
                }
                displayMap();
            }
        }
        scanner.close();
    }

    public void getNewHero() {
        this.Hero = HeroFactory.getNewHero("null");
    }
    public void getVillains() {
        this.Villains = VillainFactory.getVillains(Hero.getLevel());
    }

    // Create/Select Hero
    public void displayMap() {
        map.getMap();
    }

    // Update Hero(Model)
    // Movement
    // Update position(View)

}