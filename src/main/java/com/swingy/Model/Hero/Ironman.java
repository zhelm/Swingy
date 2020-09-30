package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Ironman extends HeroModel {

    public Ironman(String Name) {
        super(Name);
    }
    
    public Ironman(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        super(Name, level, id, Experience, Weapon, Armor, Helm);
    }


    @Override
    public void Attack(Object Enemy) {
        // TODO Auto-generated method stub

    }
    
    public static Ironman getNewIronman(String name) {
        return new Ironman(name);
    }
    public static Ironman getIronman(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        return new Ironman(Name, level, id, Experience, Weapon, Armor, Helm);
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
