package com.swingy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.swingy.Controller.GameController;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InterruptedException, IOException
    {
        GameController gameController = new GameController();
    }
}
