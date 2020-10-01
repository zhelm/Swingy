package com.swingy;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.swingy.Controller.GameController;

// if I added coordinates to db it would have been easier to detect collisions for gui

public class App {
  public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, IOException, SQLException
      {
        new GameController();
      }
}
