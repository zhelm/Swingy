package com.swingy.Model.Hero;

import java.util.ArrayList;

import com.swingy.Model.HeroModel;

public class Assasin extends HeroModel {

    public Assasin(String Name) {
        super(Name);
        this.HitPoints = 200;
        this.Attack = 150;
        this.Defence = 2;
        this.Artifacts = new ArrayList<String>();
    }

    public static Assasin getAssasin() {
        return new Assasin("Name");
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
