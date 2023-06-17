package com.smallchangesystem;

import java.util.Scanner;

public class SmallChangeSystem {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //新建账户(余额默认为0)
        Account account1 =new Account(100);
        //新建菜单
        MenuOOP menu1 = new MenuOOP();
        // 输入选项
        int option;
        //进入菜单
        System.out.println("\t\t欢迎使用零钱通！");
        System.out.println("\t\t欢迎使用零钱通！");
        System.out.println("\t\t欢迎使用零钱通！");
        do
        {
            menu1.InitialMenu();
            option = in.nextInt();
            menu1.Options(option, account1);
        } while (menu1.isFlag());
    }
}

