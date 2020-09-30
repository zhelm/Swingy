package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Thief extends HeroModel {
    public Thief(String Name) {
        super(Name);
    }

    public Thief(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        super(Name, level, id, Experience, Weapon, Armor, Helm);
    }

    public static Thief getNewThief(String name) {
        return new Thief(name);
    }

    public static Thief getThief(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        return new Thief(Name, level, id, Experience, Weapon, Armor, Helm);
    }

    
    @Override
    public void Attack(Object Enemy) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Run() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Move(String direction) {
        // TODO Auto-generated method stub

    }
}
