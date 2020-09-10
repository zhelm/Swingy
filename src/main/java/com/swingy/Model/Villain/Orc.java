package com.swingy.Model.Villain;

import com.swingy.Model.VillainModel;

public class Orc extends VillainModel {

    public Orc(int level, float multiplier, float secondMultiplier) {
        super(level, ((multiplier)*((((float)level-1)*5+10-((float)level%2)))+(secondMultiplier*2.5f)), 0.5f*(((float)level-1)*5+10-((float)level%2)));
    }
    //basic movement
}
