package com.views;

import com.events.MainEvent;
import com.events.ManagerEvent;
import com.events.UserEvent;
import com.utilities.IO_Utility;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class MHL_View {
    private boolean show1 = true;
    private boolean show2;
    private boolean show3;

    public void mainMenu()
    {
        while (show1)
        {
            System.out.println("-----------------欢迎来到满汉楼!!!---------------");
            System.out.println("1.用户登录");
            System.out.println("2.用户注册");
            System.out.println("3.管理者登录");
            System.out.println("4.退出满汉楼");
            switch (IO_Utility.Inoption())
            {
                case 1 ->
                {
                    show2 = MainEvent.userLogin();
                    userMenu();
                }
                case 2->
                {
                    MainEvent.userRegister();

                }
                case 3 ->
                {
                    show3 = MainEvent.employLogin();
                    managerMenu();
                }
                case 4 -> show1 = MainEvent.quit();
                default -> System.out.println("无此选项,请重新选择!");
            }
        }
    }


    public void userMenu()
    {
        while (show2)
        {
            System.out.println("--------------满汉楼用户菜单--------------");
            System.out.println("1.预定餐桌");
            System.out.println("2.点  餐");
            System.out.println("3.结  账");
            System.out.println("4.退  出");
            switch (IO_Utility.Inoption())
            {
                case 1 -> UserEvent.book();
                case 2 -> UserEvent.order();
                case 3 -> UserEvent.Checkout();
                case 4 -> show2 = UserEvent.quit();
                default -> System.out.println("无此选项,请重新选择!");
            }
        }
    }

    public void managerMenu()
    {
        while (show3)
        {
            System.out.println("-----------------满汉楼管理者菜单-----------------");
            System.out.println("1.更改餐桌状态");
            System.out.println("2.添 加 菜 品");
            System.out.println("3.删 除 菜 品");
            System.out.println("4.更改菜品信息");
            System.out.println("5.查 看 流 水");
            System.out.println("6.退  出");
            switch (IO_Utility.Inoption())
            {
                case 1 -> ManagerEvent.updateStatus();
                case 2 -> ManagerEvent.addMenu();
                case 3 -> ManagerEvent.deleteMenu();
                case 4 -> ManagerEvent.updateMenu();
                case 5 -> ManagerEvent.flow();
                case 6 -> show3 = ManagerEvent.quit();
                default -> System.out.println("无此选项,请重新选择!");
            }
        }
    }

    public static void main(String[] args)
    {
        new MHL_View().mainMenu();
    }
}
