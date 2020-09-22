package com.swingy.Model.Villain;

import com.swingy.Model.VillainModel;

public class DarkMage extends VillainModel {

    public DarkMage(int level, float multiplier, float secondMultiplier) {
        super("DarkMage", level, 0.5f*(((float)level-1)*5+10-((float)level%2)), ((multiplier)*((((float)level-1)*5+10-((float)level%2)))+(secondMultiplier*2.5f)));
    }

    @Override
    public void Attack(Object Enemy) {
        System.out.println("Ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
    }

    @Override
    public void Run() {
    }

    //can move in any direction even diagonal
}