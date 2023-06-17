package com.client;

import com.common.User;
import com.common.Utility;

import static java.lang.Thread.sleep;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Menu {
    private boolean show1 = true;
    private boolean show2 = false;
    private boolean show3 = true;


    public void mainMenu1()
    {
        System.out.println("-----------欢迎使用网络通信系统------------");
        System.out.println("1. 用户登录");
        System.out.println("2. 用户注册");
        System.out.println("3. 退出系统");
    }

    public void mainMenu2()
    {
        System.out.println("----------功能菜单----------");
        System.out.println("1. 显示在线用户列表");
        System.out.println("2. 私聊");
        System.out.println("3. 群发信息");
        System.out.println("4. 发送文件");
        System.out.println("5. 退出登录");
    }

    public void optionMenu1()
    {
        switch (Utility.Inoption())
        {
            //用户登录
            case 1 ->
            {
                User user = new User();
                if (Event.login(user) != 0)
                    show2 = false;
                else
                    show2 = true;
                while (show2)
                {
                    mainMenu2();
                    optionMenu2(user);
                }
            }
            //用户注册
            case 2->
            {
                User user = new User();
                if(Event.register(user)==0)
                {
                    System.out.println("请重新登录:");
                    if (Event.login(user) != 0)
                        show2 = false;
                    else
                        show2 = true;
                    while (show2)
                    {
                        mainMenu2();
                        optionMenu2(user);
                    }
                }
            }
            //退出系统
            case 3 ->
            {
                if (Utility.Inchoice())
                {
                    System.out.println("已退出系统!");
                    show1 = false;
                }
            }
        }
    }

    public void optionMenu2(User user)
    {
        switch (Utility.Inoption())
        {
            //显示在线用户
            case 1 ->
            {
                show2 = false;
                System.out.println("当前在线用户: ");
                Event.onlineusers(user);
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.print("按任意键返回上一级菜单:");
                Utility.InChar();
                show2 = true;
            }
            //私聊
            case 2 ->
            {
                Event.priChat(user);
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.print("按任意键返回上一级菜单:");
                Utility.InChar();
                show2 = true;
            }
            //群发信息
            case 3 ->
            {
                Event.mass(user);
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.print("按任意键返回上一级菜单:");
                Utility.InChar();
                show2 = true;
            }
            //发送文件
            case 4 ->
            {
                Event.sendFile(user);
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.print("按任意键返回上一级菜单:");
                Utility.InChar();
                show2 = true;
            }
            //退出登录
            case 5 ->
            {
                if (Utility.Inchoice())
                {
                    System.out.println("用户 " + user.getId() + " 已退出登录!");
                    Event.logout(user);
                    show2 = false;
                }
            }
        }
    }
    public void setShow1(boolean show1)
    {
        this.show1 = show1;
    }

    public void setShow2(boolean show2)
    {
        this.show2 = show2;
    }

    public void setShow3(boolean show3)
    {
        this.show3 = show3;
    }

    public boolean isShow1()
    {
        return show1;
    }

    public boolean isShow2()
    {
        return show2;
    }

    public boolean isShow3()
    {
        return show3;
    }

}
