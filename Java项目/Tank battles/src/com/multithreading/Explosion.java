package com.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 爆炸效果
 */
public class Explosion {
    ArrayList<Image> images = new ArrayList<>();
    public boolean exp = true;
    public int time;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean wait = true;
    Timer timer = new Timer(22, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            wait = true;
            timer.stop();
        }
    });

    public void paint(Graphics g, ImageObserver io)
    {
        wait = false;
        g.drawImage(images.get(images.size() - time), x, y, width, height, io);
        time--;
        timer.start();
    }

    public Explosion(PlayerTank tank)
    {
        this.x = tank.x;
        this.y = tank.y;
        this.width = 36;
        this.height = 36;
    }

    public Explosion(Bullet bullet)
    {
        this.x = bullet.x;
        this.y = bullet.y;
        this.width = 6;
        this.height = 6;
    }

    {
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/1.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/1.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/2.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/2.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/3.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/3.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/4.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/4.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/5.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/5.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/6.png"));
        time++;
        images.add(Toolkit.getDefaultToolkit().getImage("src/com/图片/6.png"));
        time++;

    }
}
