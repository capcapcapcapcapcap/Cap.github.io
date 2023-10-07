package com.multithreading;

import java.awt.*;
import java.io.*;
import java.util.Vector;

import static com.multithreading.Database.*;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Recorder {
    public static File file = new File("src/Archive");
    public static ObjectOutputStream writer = null;
    public static ObjectInputStream reader = null;
    static Font font1=new Font("楷体", Font.BOLD, 25);
    static Font font2 = new Font("楷体", Font.BOLD, 20);
    static Font font3 = new Font("楷体", Font.BOLD, 30);

    public static void paint(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(Window.WIDTH, 0, Window.WIDTH + 300, Window.HEIGHT);
        g.setColor(new Color(150, 25, 30));
        g.setFont(font1);
        g.drawString(" ※欢迎来到坦克大战※",Window.WIDTH , 25);
        g.setColor(new Color(200, 163, 60));
        g.setFont(font2);
        g.drawString(" 移动:  ↑ ↓ ← →", Window.WIDTH , 55);
        g.drawString("  X:  发射普通子弹 ",Window.WIDTH, 75);
        g.drawString("  C:  发射超级子弹(CD: 6s)", Window.WIDTH, 95);
        g.drawString("  Z:  加速移动", Window.WIDTH, 115);
        g.drawString("  P:  复活", Window.WIDTH, 135);
        g.drawString("  S:  存档", Window.WIDTH, 155);
        g.drawString(" 注意:  坦克被撞就会死 ", Window.WIDTH, 175);
        g.setColor(new Color(11, 176, 87));
        g.setFont(font3);
        g.drawString("战况实录", Window.WIDTH + 80, 220);
        g.drawString("×" + remain(), Window.WIDTH + 200, 255);
        new EnemyTank(Window.WIDTH + 10, 230).paint(g);
    }

    public static int remain()
    {
        int i = 0;
        for (EnemyTank tank : Database.enemytanks)
        {
            if (tank.isAlive)
                i++;
        }
        return i;
    }

    public static void save()
    {
        try
        {
            writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeInt(mytanks.get(0).x);
            writer.writeInt(mytanks.get(0).y);
            writer.writeInt(mytanks.get(0).direction);
            for (EnemyTank tank : enemytanks)
            {
                writer.writeInt(tank.x);
                writer.writeInt(tank.y);
                writer.writeInt(tank.direction);
                writer.writeObject(tank.color);
                writer.writeInt(tank.firespeed);
                writer.writeInt(tank.moveSpeed);
                writer.writeInt(tank.lives);
                writer.writeBoolean(tank.isAlive);
            }
            writer.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void readtanks(PlayerTank player, Vector<EnemyTank> enemys)
    {
        try
        {
            reader = new ObjectInputStream(new FileInputStream(file));
            {
                player.x = reader.readInt();
                player.y = reader.readInt();
                player.direction = reader.readInt();
            }
            for(EnemyTank tank: enemys)
            {
                tank.x = reader.readInt();
                tank.y = reader.readInt();
                tank.direction = reader.readInt();
                tank.color = (Color) reader.readObject();
                tank.firespeed = reader.readInt();
                tank.moveSpeed = reader.readInt();
                tank.lives = reader.readInt();
                tank.isAlive = reader.readBoolean();
            }
            reader.close();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }




}