package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Warrior extends HeroModel {
    public Warrior(String Name) {
        super(Name);
    }

    public Warrior(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        super(Name, level, id, Experience, Weapon, Armor, Helm);
    }



    public static Warrior getNewWarrior(String name) {
        return new Warrior(name);
    }

    public static Warrior getWarrior(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        return new Warrior(Name, level, id, Experience, Weapon, Armor, Helm);
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
