package com.swingy.View;

import java.util.ArrayList;
import java.util.Arrays;

import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainModel;

public class Map {
    HeroModel Hero;
    ArrayList<VillainModel> Villains;

    public Map(HeroModel Hero, ArrayList<VillainModel> Villains) {
        this.Hero = Hero;
        this.Villains = Villains;
    }

    public String[][] getMap() {

        boolean match = false;
        int middleX = Hero.getXCoordinate();
        int middleY = Hero.getYCoordinate();

        String[][] ret = new String[(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)][(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)];
        for (String[] strings : ret) {
            Arrays.fill(strings, "*");
        }
        
        // This is for the Villains
        for (int i = 0; i < Villains.size(); i++) {
            System.out.println(Villains.get(i).getClass().getSimpleName());
            System.out.println(Villains.get(i).coordinates.getXCoordinate() + " " + Villains.get(i).coordinates.getYCoordinate());

            if(Villains.get(i).getClass().getSimpleName().equals("DarkMage")) {
                ret[Villains.get(i).coordinates.getXCoordinate()][Villains.get(i).coordinates.getYCoordinate()] = "M";    
            } else if (Villains.get(i).getClass().getSimpleName().equals("Orc")) {
                ret[Villains.get(i).coordinates.getXCoordinate()][Villains.get(i).coordinates.getYCoordinate()] = "O";
            
            } else {
                ret[Villains.get(i).coordinates.getXCoordinate()][Villains.get(i).coordinates.getYCoordinate()] = "D";
            }

        }
        // // This is for the Hero
        for (int i = 0; i < ret.length; i++) {
            if(i == middleY) match = true;
            for (int j = 0; j < ret[i].length; j++) {
                if(j == middleX && match == true) {
                    match = false;
                System.out.print("H" + ' ');
                } else {
                    System.out.print(ret[i][j] + ' ');
                }
            }
            System.out.println();
        }

        return(ret);
    }

    public int getCenter() {
        return(((this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2))/2);
    }
}
