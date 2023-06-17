package com.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 敌方坦克
 */
public class EnemyTank extends PlayerTank implements Runnable {
    final private boolean friend = false;
    public int direction = 0;
    Color color = Color.RED;
    public  int firespeed = 3;
    public int moveSpeed = 1;

    public int lives = 3;

    public EnemyTank(int x, int y)
    {
        super(x, y);
    }

    public EnemyTank()
    {
        Random random = new Random();
        this.x = random.nextInt(Window.WIDTH - 50);
        this.y = random.nextInt(0,Window.HEIGHT /2-70);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

    public void run()
    {
        while (isAlive)
        {

            try
            {
                Thread.sleep(17);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            //自动射击模块
            shoot();
            //自动移动模块
            setDirection();
            move();
        }
    }

    private boolean shoot = true;
    Timer timershoot = new Timer(firespeed * 1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            shoot = true;
            timershoot.stop();
        }
    });

    public void shoot()
    {
        if (shoot)
        {
            shoot = false;
            Bullet bullet = new Bullet(this);
            bullet.start();
            Database.allbullets.add(bullet);
            this.timershoot.start();
        }
    }

    private boolean flag = true;
    Random random = new Random();
    int delay= random.nextInt(1000,3000);
    Timer timer = new Timer(delay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            flag = true;
            timer.stop();
        }
    });
    public void setDirection()
    {
        if (flag)
        {
            flag = false;
            int i = random.nextInt(4);
//            if (i < 4)
                this.direction = i + 1;
            timer.start();
        }
    }

    public void move()
    {
        if (direction == 3 && this.x >= 5)
            this.x -= this.moveSpeed;
        else if (direction == 2 && this.x + 45 <= Window.WIDTH)
            this.x += this.moveSpeed;
        else if (direction == 1 && this.y >= 5)
            this.y -= this.moveSpeed;
        else if (direction == 4 && this.y + 74 <= Window.HEIGHT)
            this.y += this.moveSpeed;
    }

    @Override
    public boolean isFriend()
    {
        return friend;
    }

    @Override
    public int getDirection()
    {
        return direction;
    }

    @Override
    public Color getColor()
    {
        return color;
    }

    public  void setFirespeed(int speed)
    {
        this.firespeed = speed;
    }

    @Override
    public int getLives()
    {
        return lives;
    }

    @Override
    public void setLives(int lives)
    {
        this.lives = lives;
    }
}
