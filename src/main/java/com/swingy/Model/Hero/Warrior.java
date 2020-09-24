package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Warrior extends HeroModel {
    public Warrior(String Name, int level) {
        super(Name, level);
    }

    public static Warrior getWarrior(String name, int level) {
        return new Warrior(name, level);
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
