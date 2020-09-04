package com.swingy.View;

import java.util.Arrays;

import com.swingy.Model.HeroModel;

public class Map {
    HeroModel Hero;

    public Map(HeroModel Hero) {
        this.Hero = Hero;
    }

    public String[][] getMap() {

        boolean match = false;
        int middleX = Hero.getXCoordinate();
        int middleY = Hero.getYCoordinate();

        // int[][] multi = new int[3][3];
        // for (int[] array : multi) {
        //     Arrays.fill(array, 9);
        // }

        String[][] ret = new String[(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)][(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)];
        for (String[] strings : ret) {
            Arrays.fill(strings, "*");
        }

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
