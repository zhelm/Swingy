package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Warrior extends HeroModel {
    public Warrior(String Name) {
        super(Name);
    }

    public static Warrior getWarrior() {
        return new Warrior("Name");
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
