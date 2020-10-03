package com.swingy.Model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

public class VillainModel {

    @NotNull
    private int Attack;

    @NotNull
    public String Type;

    @NotNull
    private int HitPoints;

    public Coordinates coordinates;

    public VillainModel(String Type, int level, int Attack, int HitPoints, float villainX, float villainY) {
        this.coordinates = new Coordinates(level, villainX, villainY);
        this.Type = Type;
        this.HitPoints = HitPoints;
        this.Attack = Attack;
    }

    public void moveVillain(int x, int y, ArrayList<VillainModel> Villains) {
        // Already check if a collision happens here. Lets not do that here
        if (this.coordinates.getYCoordinate() > y && !checkHeroCollision(x, y, 0, -1)) {
            this.coordinates.moveNorth(Villains, 1);
        } else if (this.coordinates.getXCoordinate() > x && !checkHeroCollision(x, y, -1, 0)) {
            this.coordinates.moveWest(Villains, 1);
        } else if (this.coordinates.getYCoordinate() < y && !checkHeroCollision(x, y, 0, 1)) {
            this.coordinates.moveSouth(Villains, 1);
        } else if (this.coordinates.getXCoordinate() < x && !checkHeroCollision(x, y, 1, 0)) {
            this.coordinates.moveEast(Villains, 1);
        }
    }

    private boolean checkHeroCollision(int HeroX, int HeroY, int amountX, int amountY) {
        if ((this.coordinates.getXCoordinate() + amountX) == HeroX
                && (this.coordinates.getYCoordinate() + amountY) == HeroY) {
            return true;
        }
        return false;
    }

    public int getHitpoints() {
        return this.HitPoints;
    }

    public int getAttack() {
        return this.Attack;
    }

    public void recieveDamage(int amount) {
        this.HitPoints = this.HitPoints - amount;
    }
}
