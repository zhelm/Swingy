package com.swingy.Model;

import com.swingy.Model.SwingyDatabase.SwingyDatabase;

public abstract class HeroFactory {

    public static HeroModel getNewHero(String name, int type) {
        return SwingyDatabase.createNewHero(type, name);
    }

    public static HeroModel getHero(int HeroID) {
        return SwingyDatabase.getSelectedHero(HeroID);
    }
}
