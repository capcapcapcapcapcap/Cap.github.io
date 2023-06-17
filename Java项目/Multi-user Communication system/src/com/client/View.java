package com.client;

import static java.lang.Thread.sleep;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class View {
    public static void main(String[] args)
    {
        Menu menu1 = new Menu();
        while (menu1.isShow1())
        {
            menu1.mainMenu1();
            menu1.optionMenu1();
        }
        System.exit(0);
    }
}
