package com.swingy.View;

import java.util.ArrayList;
import java.util.Arrays;

import com.swingy.Controller.GameController;
import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainModel;

public class Map {
    public HeroModel Hero;
    private static Map map = new Map();
    public ArrayList<VillainModel> Villains;

    private Map() {
    }

    public static Map thisMap() {
        return map;
    }

    public String[][] getMap() {
        boolean match = false;
        int middleX = Hero.getXCoordinate();
        int middleY = Hero.getYCoordinate();

        String[][] ret = new String[(this.Hero.getLevel() - 1) * 5 + 10
                - (this.Hero.getLevel() % 2)][(this.Hero.getLevel() - 1) * 5 + 10 - (this.Hero.getLevel() % 2)];
        for (String[] strings : ret) {
            Arrays.fill(strings, "*");
        }

        for (int i = 0; i < Villains.size(); i++) {
            ret[Villains.get(i).coordinates.getYCoordinate()][Villains.get(i).coordinates.getXCoordinate()] = String.valueOf(Villains.get(i).Type.charAt(0));
        }
        if(GameController.isConsole) {
            displayHeroStats();
        }
        for (int i = 0; i < ret.length; i++) {
            if (i == middleY)
                match = true;
            for (int j = 0; j < ret[i].length; j++) {
                if (j == middleX && match == true) {
                    match = false;
                    ret[i][j] = "H";
                    if(GameController.isConsole) {
                        System.out.print("H" + ' ');
                    }
                } else {
                    if(GameController.isConsole) {
                        System.out.print(ret[i][j] + ' ');
                    }
                }
            }
            if(GameController.isConsole) {
                System.out.println();
            }
        }

        return (ret);
    }

    private void displayHeroStats() {

        System.out.println("Name: " + Hero.getName());
        System.out.println("Class: " + Hero.getType());
        System.out.println("Level: " + Hero.getLevel());
        System.out.println("Experience: " + Hero.getExperience());
        System.out.println("Health: " + Hero.getHitpoints());
        System.out.println("Attack: " + Hero.getAttack());
        System.out.println("Defence: " + Hero.getDefence());
    }

    public int getCenter() {
        return (((this.Hero.getLevel() - 1) * 5 + 10 - (this.Hero.getLevel() % 2)) / 2);
    }
}
