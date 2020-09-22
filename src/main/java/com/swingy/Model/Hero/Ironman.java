package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Ironman extends HeroModel {

    public Ironman(String Name) {
        super(Name);
    }
    
    @Override
    public void Attack(Object Enemy) {
        // TODO Auto-generated method stub

    }

    public static Ironman getIronman() {
        return new Ironman("Name");
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
