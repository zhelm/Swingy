package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Joker extends HeroModel {

    public Joker(String Name) {
        super(Name);
    }

    public Joker(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        super(Name, level, id, Experience, Weapon, Armor, Helm);
    }

    public static Joker getNewJoker(String name) {
        return new Joker(name);
    }

    public static Joker getJoker(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        return new Joker(Name, level, id, Experience, Weapon, Armor, Helm);
    }
    @Override
    public void Attack(Object Enemy) {
        // *TODO Auto-generated method stub

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
