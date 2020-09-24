package com.swingy.View;

import java.util.ArrayList;
import java.util.Arrays;

import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainModel;

public class Map {
    public HeroModel Hero;
    ArrayList<VillainModel> Villains;
    public int mapSize; 

    public Map(HeroModel Hero, ArrayList<VillainModel> Villains) {
        if(Hero != null) {
            this.Hero = Hero;
            this.Villains = Villains;
            mapSize = (this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2);
        }
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
            if(Villains.get(i).getClass().getSimpleName().equals("DarkMage")) {
                ret[Villains.get(i).coordinates.getYCoordinate()][Villains.get(i).coordinates.getXCoordinate()] = "M";    
            } else if (Villains.get(i).getClass().getSimpleName().equals("Orc")) {
                ret[Villains.get(i).coordinates.getYCoordinate()][Villains.get(i).coordinates.getXCoordinate()] = "O";
            
            } else {
                ret[Villains.get(i).coordinates.getYCoordinate()][Villains.get(i).coordinates.getXCoordinate()] = "D";
            }

        }
        // // This is for the Hero
        for (int i = 0; i < ret.length; i++) {
            if(i == middleY) match = true;
            for (int j = 0; j < ret[i].length; j++) {
                if(j == middleX && match == true) {
                    match = false;
                    ret[i][j] = "H";
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
