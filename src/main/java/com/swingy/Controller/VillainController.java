package com.swingy.Controller;

import java.util.ArrayList;

import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainModel;

public abstract class VillainController {

    public VillainController() {
        super();
    }

    public static void moveVillains(ArrayList<VillainModel> Villains, HeroModel Hero) {
        for (int i = 0; i < Villains.size(); i++) {
            Villains.get(i).moveVillain(Hero.getXCoordinate(), Hero.getYCoordinate());
        }
    }
}
