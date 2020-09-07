package com.swingy.Model.Villain;

import com.swingy.Model.VillainModel;

public class DarkMage extends VillainModel {

    public DarkMage(int level) {
        super(level, 0.5f, 0f);
        System.out.println("I am the dark mage");
    }
    //can move in any direction even diagonal
}
