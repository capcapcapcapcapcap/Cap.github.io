package com.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.Random;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 我方坦克
 */
public class PlayerTank implements KeyListener{
    public int x;
    public int y;
    final private boolean friend = true;
    public int direction;
    Color color = new Color(38, 215, 235);
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    //坦克方向:1-向上，2-向右，3-向左，4-向下
    //按Z加速~~~
    public int movespeed = 3;
    public int lives = 1;
    public boolean isAlive = true;

    public PlayerTank(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public PlayerTank()
    {
        Random random = new Random();
        this.x = random.nextInt(Window.WIDTH - 50);
        this.y = random.nextInt(Window.HEIGHT / 2, Window.HEIGHT - 70);
    }

    public void paint(Graphics g)
    {
        g.setColor(getColor());
        switch (getDirection())
        {
            case 0, 1 ->
            {
                g.fill3DRect(x, y, 10, 36, false);
                g.fill3DRect(x + 26, y, 10, 36, false);
                g.setColor(Color.gray);
                g.fill3DRect(x + 10, y + 6, 16, 20, true);
                g.setColor(Color.ORANGE);
                g.fillOval(x + 10, y + 12, 16, 8);
                g.setColor(Color.gray);
                g.fill3DRect(x + 16, y - 10, 4, 16, true);
            }
            case 2 ->
            {
                g.fill3DRect(x, y, 36, 10, false);
                g.fill3DRect(x, y + 26, 36, 10, false);
                g.setColor(Color.gray);
                g.fill3DRect(x + 6, y + 10, 20, 16, true);
                g.setColor(Color.ORANGE);
                g.fillOval(x + 12, y + 10, 8, 16);
                g.setColor(Color.gray);
                g.fill3DRect(x + 26, y + 16, 16, 4, true);
            }
            case 3 ->
            {
                g.fill3DRect(x, y, 36, 10, false);
                g.fill3DRect(x, y + 26, 36, 10, false);
                g.setColor(Color.gray);
                g.fill3DRect(x + 6, y + 10, 20, 16, true);
                g.setColor(Color.ORANGE);
                g.fillOval(x + 12, y + 10, 8, 16);
                g.setColor(Color.gray);
                g.fill3DRect(x - 10, y + 16, 16, 4, true);
            }
            case 4 ->
            {
                g.fill3DRect(x, y, 10, 36, false);
                g.fill3DRect(x + 26, y, 10, 36, false);
                g.setColor(Color.gray);
                g.fill3DRect(x + 10, y + 8, 16, 20, true);
                g.setColor(Color.ORANGE);
                g.fillOval(x + 10, y + 14, 16, 8);
                g.setColor(Color.gray);
                g.fill3DRect(x + 16, y + 26, 4, 16, true);
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    private boolean isX = false;
    Timer timerX = new Timer(650, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            isX = false;
            timerX.stop();
        }
    });
    private boolean isC = false;
    Timer timerC = new Timer(6000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            isC = false;
            timerC.stop();
        }
    });

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP ->
            {
                this.up = true;
                this.direction = 1;
            }
            case KeyEvent.VK_DOWN ->
            {
                this.down = true;
                this.direction = 4;
            }
            case KeyEvent.VK_LEFT ->
            {
                this.left = true;
                this.direction = 3;
            }
            case KeyEvent.VK_RIGHT ->
            {
                this.right = true;
                this.direction = 2;
            }
            case KeyEvent.VK_Z -> this.movespeed = 5;
            case KeyEvent.VK_X ->
            {
                if (isAlive)
                {
                    if (!isX)
                    {
                        isX = true;
                        //创建并启动一个我方子弹线程
                        Bullet bullet = new Bullet(this);
                        new Thread(bullet).start();
                        Database.allbullets.add(bullet);
                        timerX.start();
                    }
                }
            }
            case KeyEvent.VK_C ->
            {
                if (isAlive)
                {
                    if (!isC)
                    {
                        isC = true;
                        //创建并启动一个我方子弹线程
                        superBullet();
                        timerC.start();
                    }
                }
            }
        }
        checkKey();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP ->
            {
                this.up = false;
                this.direction = 1;
            }
            case KeyEvent.VK_DOWN ->
            {
                this.down = false;
                this.direction = 4;
            }
            case KeyEvent.VK_LEFT ->
            {
                this.left = false;
                this.direction = 3;
            }
            case KeyEvent.VK_RIGHT ->
            {
                this.right = false;
                this.direction = 2;
            }
            case KeyEvent.VK_Z -> this.movespeed = 2;
        }
        checkKey();
    }

    public void checkKey()
    {
        if (this.left && this.x >= 5)
            this.x -= this.movespeed;
        else if (this.right && this.x + 45 <= Window.WIDTH)
            this.x += this.movespeed;
        else if (this.up && this.y >= 5)
            this.y -= this.movespeed;
        else if (this.down && this.y + 74 <= Window.HEIGHT)
            this.y += this.movespeed;
    }

    public void superBullet()
    {
        Bullet bullet = new Bullet(this);
        bullet.color = Color.MAGENTA;
        bullet.speed = 6;
        bullet.width = 12;
        bullet.height = 12;
        bullet.attack = 3;
        bullet.x -= 3;
        bullet.y -= 4;
        new Thread(bullet).start();
        Database.allbullets.add(bullet);
    }

    public int getDirection()
    {
        return direction;
    }

    public boolean isFriend()
    {
        return friend;
    }

    public Color getColor()
    {
        return color;
    }

    public int getLives()
    {
        return lives;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }
}
