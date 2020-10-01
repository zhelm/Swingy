package com.swingy.Model;

import java.util.ArrayList;
import java.util.Random;

import com.swingy.Model.SwingyDatabase.SwingyDatabase;

public abstract class VillainFactory {
    public static ArrayList<VillainModel> getVillains(int level) {
        if(level >= 0) {
            return getVillainList(level);
        }
        return null;
    }

    public static ArrayList<VillainModel> getVillainList(int level) {

        ArrayList<String[]> list = SwingyDatabase.getVillainTypes();
        ArrayList<VillainModel> villainModelArrayList = new ArrayList<VillainModel>();

        for (int i = 0; i < level + 1; i++) {
            for (String[] villainType : list) {
                Random rand = new Random();
                float x = (float)((level-1)*5+10-(level%2)) * rand.nextFloat();
                float y = (float)((level-1)*5+10-(level%2)) * rand.nextFloat();

                villainModelArrayList.add(new VillainModel(villainType[1], level, Integer.parseInt(villainType[3]), Integer.parseInt(villainType[2]), x, y));
            }        
        }
        return villainModelArrayList;
    }
    
}
