package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Ironman extends HeroModel {

    public Ironman(String Name, int level) {
        super(Name, level);
    }
    
    @Override
    public void Attack(Object Enemy) {
        // TODO Auto-generated method stub

    }

    public static Ironman getIronman(String name, int level) {
        return new Ironman(name, level);
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
