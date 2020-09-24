package com.swingy.Model.Hero;

import com.swingy.Model.HeroModel;

public class Joker extends HeroModel {

    public Joker(String Name, int level) {
        super(Name, level);
    }

    public static Joker getJoker(String name, int level) {
        return new Joker(name, level);
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
