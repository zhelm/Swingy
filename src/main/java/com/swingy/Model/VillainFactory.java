package com.swingy.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.swingy.Model.Villain.DarkMage;
import com.swingy.Model.Villain.Demon;
import com.swingy.Model.Villain.Orc;

public abstract class VillainFactory {
    public static ArrayList<VillainModel> getVillains(int level) {
        if(level >= 0) {
            return getVillainList(level);
        }
        return null;
    }

    public static ArrayList<VillainModel> getVillainList(int level) {
        ArrayList<VillainModel> list = new ArrayList<VillainModel>();
        // Todo for loop that has multiplier that will have these values stay in same position per level and expand when a level is added
        // Either starts at max or it starts at 0
        float newMultiplier = (level%2 > 0) ? 1 : 0;
        for (int i = 0; i < level + 1; i++) {
            float mult = (newMultiplier == 0) ? 1 : -1;
            
            list.add(new DarkMage(level, newMultiplier, i*(mult)));
            // list.add(new Orc(level, newMultiplier, i*(mult)));
            // list.add(new Demon(level, newMultiplier, i*(mult*-1)));
            newMultiplier = (newMultiplier == 1) ? 0 : 1;
        }
        return list;
    }
    // The floats are making things wierd
    
}
