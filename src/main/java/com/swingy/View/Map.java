package com.swingy.View;

import java.util.Arrays;

import com.swingy.Model.HeroModel;

public class Map {
    HeroModel Hero;

    public Map(HeroModel Hero) {
        this.Hero = Hero;
    }

    public String[][] getMap() {

        // int[][] multi = new int[3][3];
        // for (int[] array : multi) {
        //     Arrays.fill(array, 9);
        // }

        String[][] ret = new String[(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)][(this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2)];
        for (String[] strings : ret) {
            Arrays.fill(strings, "*");
        }

        for (String[] strings : ret) {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i] + ' ');
            }
            System.out.println();
        }
        
        return(ret);
    }
    public int getCenter() {
        return(((this.Hero.getLevel()-1)*5+10-(this.Hero.getLevel()%2))/2);
    }
}
