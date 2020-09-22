package com.swingy.Model.Villain;

import com.swingy.Model.VillainModel;

public class Demon extends VillainModel {

    // Its sittng ontop of each other
    public Demon(int level, float multiplier, float secondMultiplier) {
        super("Demon", level, (((multiplier == 0) ? 1 : 0)*((((float)level-1)*5+10-((float)level%2)))+(secondMultiplier*2.5f)), (((multiplier == 0) ? 1 : 0)*((((float)level-1)*5+10-((float)level%2)))+(secondMultiplier*2.5f)));
    }
    // moves 2 spaces at a time in normal directions

    @Override
    public void Attack(Object Enemy) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Run() {
        // TODO Auto-generated method stub

    }
}
