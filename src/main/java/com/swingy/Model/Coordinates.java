package com.swingy.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Coordinates {
    
    private VillainModel ret;
    private float x;
    private float y;
    private int mapsize;

    // This one is for the Hero
    public Coordinates(int Level) {
        mapsize = (Level - 1) * 5 + 10 - (Level % 2);
        x = mapsize / 2;
        y = x;
    }

    // This one is for the Villain
    public Coordinates(int level, float villainX, float villainY) {
        mapsize = (level - 1) * 5 + 10 - (level % 2);
        x = villainX;
        y = villainY;

        if (x == mapsize)
            x--;
        if (y == mapsize)
            y--;
    }

    public int getXCoordinate() {
        return (int) this.x;
    }

    public int getYCoordinate() {
        return (int) this.y;
    }

    public int getMapSize() {
        return this.mapsize;
    }

    private void moveXCoordinate(int n) {
        this.x = this.x + n;
    }

    private void moveYCoordinate(int n) {
        this.y = this.y + n;
    }

    public VillainModel moveNorth(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving North");
        if((ret = collisionNorthSouth(Villains, 0, -amount)) == null) {
            this.moveYCoordinate(-amount);
        }
        return ret;
    }

    public VillainModel moveSouth(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving South");
        if((ret = collisionNorthSouth(Villains, 0, amount)) == null) {
            this.moveYCoordinate(amount);
        }
        return ret;
    }

    public VillainModel moveWest(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving West");
        if((ret = collisionNorthSouth(Villains, -amount, 0)) == null) {
            this.moveXCoordinate(-amount);
        }
        return ret;
    }

    public VillainModel moveEast(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving East");
        if((ret = collisionNorthSouth(Villains, amount, 0)) == null) {
            this.moveXCoordinate(amount);
        }
        return ret;
    }

    private VillainModel collisionNorthSouth(ArrayList<VillainModel> Villains, int x, int y) {
        for (int i = 0; i < Villains.size(); i++) {
            if((this.getXCoordinate() + x) == Villains.get(i).coordinates.getXCoordinate() && (this.getYCoordinate() + y) == Villains.get(i).coordinates.getYCoordinate()) {
                System.out.println(this.getClass());
                System.out.println("<---------------------- Collision Detected ---------------------->");
                return Villains.get(i);
            }
        }
        return null;
    }
    

    public boolean isWin() {
        if(getXCoordinate() >= getMapSize() || getXCoordinate() < 0 || getYCoordinate() >= getMapSize() || getYCoordinate() < 0) {
            return true;
        }
        return false;
    }

    //Hero uses this movement method
    public VillainModel moveDirection(String direction, ArrayList<VillainModel> Villains)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {
        Method method;
        var cArg = new Class[2];
        cArg[0] = Villains.getClass();
        System.out.println(cArg[0]);
        cArg[1] = int.class;
        
        method = this.getClass().getMethod("move" + direction, cArg);
        return (VillainModel)method.invoke(this, Villains, 1);
    }


}
