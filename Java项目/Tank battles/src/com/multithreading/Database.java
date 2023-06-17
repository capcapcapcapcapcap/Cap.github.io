package com.multithreading;

import java.awt.*;
import java.util.Vector;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Database  {
    public static Vector<PlayerTank> mytanks = new Vector<>();
    public static Vector<EnemyTank> enemytanks = new Vector<>();
    public static Vector<PlayerTank> alltanks = new Vector<>();
    public static Vector<Bullet> allbullets = new Vector<>();
    public static Vector<Explosion> allexplosions = new Vector<>();
    public static void addEnemy()
    {
        Database.enemytanks.add(new EnemyTank());
    }

    public static void addEnemy(int x, int y)
    {
        Database.enemytanks.add(new EnemyTank(x, y));
    }

    public static void addBoss()
    {
        EnemyTank Boss = new EnemyTank();
        Boss.color = Color.blue;
        Boss.lives = 10;
        Boss.firespeed = 1;
        Boss.moveSpeed = 2;
        Database.enemytanks.add(Boss);
    }


    public static void addMy(int x, int y)
    {
        Database.mytanks.add(new PlayerTank(x, y));
    }

    public static void addMy()
    {
        Database.mytanks.add(new PlayerTank());
    }
}
