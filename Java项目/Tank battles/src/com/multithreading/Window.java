package com.multithreading;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

import static com.multithreading.Database.*;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 * 窗口
 */
public class Window extends JFrame {
    public static int WIDTH = 600;
    public static int HEIGHT = 600;


    public Window() throws IOException
    {
        this.setTitle("Tank Battle");
        this.setLocation(240, 60);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel myPanel = new MyPanel();
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
    }

    public Window(int width, int height) throws IOException
    {
        this();
        WIDTH = width;
        HEIGHT = height;
        this.setSize(WIDTH + 300, HEIGHT);
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("-----------请选择-----------");
        System.out.println("Z: 新的开始\t X: 读取存档");
        Scanner in = new Scanner(System.in);
        char ch = in.next().charAt(0);
        initialize();
        if (ch == 'x')
            readArc();
        for (EnemyTank Tank : Database.enemytanks)
        {
            new Thread(Tank).start();
        }
        new BGM().start();
        new Window(800, 750);
    }

    public static void initialize()
    {
        addMy();
        addEnemy();
        addEnemy();
        addEnemy();
        addEnemy();
        addEnemy();
        addBoss();
        Database.alltanks.addAll(Database.mytanks);
        Database.alltanks.addAll(Database.enemytanks);
    }

    public static void readArc()
    {
        Recorder.readtanks(mytanks.get(0), enemytanks);
    }


}
