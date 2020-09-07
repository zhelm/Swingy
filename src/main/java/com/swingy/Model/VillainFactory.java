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
        list.add(new DarkMage(level));
        list.add(new Orc(level));
        list.add(new Demon(level));
        return list;
    }
}
