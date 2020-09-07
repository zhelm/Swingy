package com.swingy.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.swingy.Model.Villain.DarkMage;
import com.swingy.Model.Villain.Demon;
import com.swingy.Model.Villain.Orc;

public abstract class VillainFactory {
    public static ArrayList<VillainModel> getVillains(int level) {
        if(level == 0) {
            return getVillainList(level);
        } else if (level == 1) {
            return getVillainList(level);
        } else {
            return null;
        }
    }

    public static ArrayList<VillainModel> getVillainList(int level) {
        ArrayList<VillainModel> list = new ArrayList<VillainModel>();
        // Todo for loop that has multiplier that will have these values stay in same position per level and expand when a level is added
        for (float i = 0; i < level + 1; i++) {
            list.add(new DarkMage(level, (1f)/(i+1f)));
            list.add(new Orc(level, 1f/(i+1f)));
            list.add(new Demon(level, 1f/(i+1f)));
        }
        System.out.println("Hello WOlrd");
        for (VillainModel villainModel : list) {
            System.out.println(villainModel.coordinates.getXCoordinate() + " " + villainModel.coordinates.getYCoordinate());
        }
        return list;
    }
}
