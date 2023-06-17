package com.multithreading;

import java.awt.*;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 子弹
 */
public class Bullet extends Thread {
    public int x;
    public int y;
    public int width = 6;
    public int height = 6;
    public int speed = 10;
    public int attack=1;
    public final int direction;
    public boolean friend;
    Color color ;
    public boolean isAlive = true;

    public Bullet(PlayerTank tank)
    {
        this.direction = tank.getDirection();
        this.friend = tank.isFriend();
        this.color = tank.getColor();
        switch (this.direction)
        {
            case 0, 1 ->
            {
                this.x = tank.x + 15;
                this.y = tank.y - 15;
            }
            case 2 ->
            {
                this.x = tank.x + 42;
                this.y = tank.y + 15;
            }
            case 3 ->
            {
                this.x = tank.x - 15;
                this.y = tank.y + 15;
            }
            case 4 ->
            {
                this.x = tank.x + 15;
                this.y = tank.y + 42;
            }
        }
    }

    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void run()
    {
        //子弹移动
        while (true)
        {
            try
            {
                Thread.sleep(speed);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            switch (direction)
            {
                case 0, 1 -> y -= 1;
                case 2 -> x += 1;
                case 3 -> x -= 1;
                case 4 -> y += 1;
            }
            if (x < -3 || x+6 > Window.WIDTH || y > Window.HEIGHT || y < -3)
            {
                isAlive = false;
            }
            if (!isAlive)
               break;
        }
    }

}
