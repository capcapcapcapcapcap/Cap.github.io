package com.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
@SuppressWarnings("all")
public class Draw extends JFrame {
    private boolean isC = false;
    Timer timerC = new Timer(6000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            isC = false;
            timerC.stop();
        }
    });
    public Draw()
    {
//        MyPanel panel = new MyPanel();


        this.setTitle("坦克大战");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args)
    {
        new Draw();
    }
}



class Tank  {
    private int x;
    private int y;
    private boolean friend;

    public Tank(Graphics g)
    {
        this.x = 200;
        this.y = 200;
        this.friend = true;
        if (friend)
        {
            g.setColor(Color.CYAN);
        } else
        {
            g.setColor(Color.RED);
        }
        g.fill3DRect(x, y, 10, 34, false);
        g.fill3DRect(x + 26, y, 10, 34, false);
        g.setColor(Color.BLACK);
        g.fill3DRect(x + 10, y + 6, 16, 20, true);
        g.setColor(Color.ORANGE);
        g.fillOval(x + 10, y + 12, 16, 8);
        g.setColor(Color.BLACK);
        g.fill3DRect(x + 16, y - 10, 4, 16, true);

    }

    public Tank(int x, int y, boolean friend,Graphics g)
    {
        this.x = x;
        this.y = y;
        this.friend = friend;
        if (friend)
        {
            g.setColor(Color.CYAN);
        } else
        {
            g.setColor(Color.RED);
        }
        g.fill3DRect(x, y, 10, 34, false);
        g.fill3DRect(x + 26, y, 10, 34, false);
        g.setColor(Color.BLACK);
        g.fill3DRect(x + 10, y + 6, 16, 20, true);
        g.setColor(Color.ORANGE);
        g.fillOval(x + 10, y + 12, 16, 8);
        g.setColor(Color.BLACK);
        g.fill3DRect(x + 16, y - 10, 4, 16, true);

    }



}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //画直线，(x1,y1)和(x2,y2)为直线的两个端点
        g.drawLine(100, 200, 100, 300);
        //画类圆形，(x,y)点为外包矩形的左上角，(w,h)为外包矩形的长宽
        g.drawOval(100, 100, 100, 100);
        //画矩形边框，(x,y)点为矩形的左上角，(w,h)为矩形的长宽
        g.drawRect(100, 100, 100, 100);

        //设置画笔颜色
        g.setColor(Color.CYAN);
        //填充矩形，(x,y)点为矩形的左上角，(w,h)为矩形的长宽
        g.fillRect(100, 100, 100, 100);
        //填充类圆形，(x,y)点为外包矩形的左上角，(w,h)为外包矩形的长宽
        g.fillOval(100, 100, 100, 100);

        //画图片
        //先获取图片资源 “/” 表示根目录
        Image img = Toolkit.getDefaultToolkit().getImage("out/production/Tank battles/a.png");
        //再调整图片位置和大小
        g.drawImage(img, 100, 100, 100, 100, this);


        // 设置字体和颜色
        g.setFont(new Font("Consolas", Font.BOLD, 30));
        g.setColor(Color.RED);
        //画字符串
        g.drawString("Tank battles", 100, 200);
    }
}