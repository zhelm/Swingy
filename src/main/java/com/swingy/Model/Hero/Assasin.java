package com.swingy.Model.Hero;

import java.util.ArrayList;

import com.swingy.Model.HeroModel;

public class Assasin extends HeroModel {

    public Assasin(String Name, int level) {
        super(Name, level);
        this.HitPoints = 200;
        this.Attack = 150;
        this.Defence = 2;
        this.Artifacts = new ArrayList<String>();
    }

    public static Assasin getAssasin(String name, int level) {
        return new Assasin(name, level);
    }

    @Override
    public void Attack(Object Villain) {
        
        System.out.println("Ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
    }

    @Override
    public void Run() {

    }

    @Override
    public void Move(String direction) {
        
    }

    
}
