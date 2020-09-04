package com.swingy.Model;

public class Coordinates {
    
    private int x;
    private int y;

    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public void moveXCoordinate(int n) {
        this.x = this.x + n;
    }

    public void moveYCoordinate(int n) {
        this.y = this.y + n;
    }

}
