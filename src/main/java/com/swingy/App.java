package com.swingy;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.swingy.Controller.GameController;
import com.swingy.Model.HeroModel;
import com.swingy.Model.SwingyDatabase.SwingyDatabase;

public class App {
    public static void main(String[] args)
      {
        SwingyDatabase.createInitialTables();
        HeroModel hero = new HeroModel("Bob");
      }
}
