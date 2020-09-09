package com.swingy.Model;

public class VillainModel {

    private String Name;
    
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    public Coordinates coordinates;

    public VillainModel(int level, float villainX, float villainY) {
        this.coordinates = new Coordinates(level, villainX, villainY);
    }
}
