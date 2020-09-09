package com.swingy.Model.Villain;

import com.swingy.Model.VillainModel;

public class Demon extends VillainModel {

    // Its sittng ontop of each other
    public Demon(int level, float multiplier) {
        super(level, 1f, 1f);
        System.out.println("Whoooo hooo let get things rollin!!!!!!!!!!!");
    }
    // moves 2 spaces at a time in normal directions
}
