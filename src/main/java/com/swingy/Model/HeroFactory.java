package com.swingy.Model;

import com.swingy.Model.Hero.Assasin;

public abstract class HeroFactory {

    public static HeroModel getNewHero(String Name) {
        return new Assasin(Name);
    }
    // TODO
    //getAssasin();
    //getIronman();
    //getJoker();
    //getThief();
    //getWarrior();
}
