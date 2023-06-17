package com.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 画板
 */
public class MyPanel extends JPanel implements Runnable, KeyListener {
    public Vector<PlayerTank> mytanks = new Vector<>();
    public Vector<EnemyTank> enemytanks = new Vector<>();
    public Vector<PlayerTank> alltanks = new Vector<>();
    public Vector<Bullet> allbullets = new Vector<>();
    public Vector<Explosion> allexplosions = new Vector<>();


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(19, 18, 26));
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        Recorder.paint(g);
        //画坦克和子弹
        if (Database.alltanks.size() > 0)
            for (PlayerTank tank : Database.alltanks)
                if (tank.isAlive)
                    tank.paint(g);
        for (int i = 0; i < Database.allbullets.size(); i++)
        {
            Bullet bullet = Database.allbullets.get(i);
            if (bullet.isAlive)
                bullet.paint(g);
        }
        if (Database.allexplosions.size() > 0)
            for (Explosion explosion : Database.allexplosions)
            {
                if (explosion.wait && explosion.time > 0)
                {
                    explosion.paint(g, this);
                }
            }
        if(Recorder.remain()==0)
        {
            g.drawImage(Toolkit.getDefaultToolkit().getImage("D:\\IntelliJ IDEA 2022.2.3\\Java项目\\Tank battles\\src\\com\\图片\\8.jpg"),0,200,Window.WIDTH,200,this);
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (Database.allbullets.size() > 50)
                Event.removeBullet();
            Event.beAlive();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        Database.mytanks.get(0).keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Database.mytanks.get(0).keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_P)
        {
            if (!Database.mytanks.get(0).isAlive)
            {
                Database.mytanks.set(0, new PlayerTank());
                Database.alltanks.add(Database.mytanks.get(0));
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S)
        {
            Recorder.save();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Database.mytanks.get(0).keyReleased(e);
    }


}
