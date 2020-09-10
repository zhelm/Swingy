package com.swingy.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Coordinates {

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
        y = villainX;
        x = villainY;

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

    public boolean moveNorth() {
        this.moveYCoordinate(-1);
        if(getYCoordinate() < 0) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveSouth() {
        this.moveYCoordinate(1);
        if(getYCoordinate() >= getMapSize()) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveWest() {
        this.moveXCoordinate(-1);
        if(getXCoordinate() < 0) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveEast() {
        this.moveXCoordinate(1);
        if(getXCoordinate() >= getMapSize()) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveDirection(String direction)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {
        Method method;
        method = this.getClass().getMethod("move" + direction);
        return (boolean)method.invoke(this);
    }


}
