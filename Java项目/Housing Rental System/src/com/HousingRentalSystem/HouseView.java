package com.HousingRentalSystem;

import java.util.Scanner;

/**
 * The type House view.
 * 1.显示界面
 * 2.接收输入
 * 3.调用其他类的方法，完成对房屋信息处理
 */
public class HouseView {
    /**
     * Main Menu.
     */
    private boolean loop = true;

    /**
     * Is loop boolean.
     *
     * @return the boolean
     */
    public boolean isLoop()
    {
        return loop;
    }

    /**
     * Main menu.
     */
    public void mainMenu()
    {
        System.out.println("-----------------房屋出租系统-------------------");
        System.out.println("1. 新增房源");
        System.out.println("2. 删除房源");
        System.out.println("3. 查找房源");
        System.out.println("4. 修改房源信息");
        System.out.println("5. 查看房源信息列表");
        System.out.println("6. 退    出");
    }

    /**
     * Options menu.
     */
    public void OptionsMenu()
    {
        switch (Utility.Inoption())
        {
            case 1 -> HouseService.AddHouse();
            case 2 -> HouseService.DeleteHouse();
            case 3 -> HouseService.FindHouse();
            case 4 -> HouseService.ChangeHouse();
            case 5 -> HouseService.ShowHouse();
            case 6 ->
            {
                System.out.print("请确认是否退出系统：");
                if (Utility.Inchoice())
                {
                    loop = false;
                }
            }
            default ->
            {
                System.out.println("选择错误，请重选：");
                OptionsMenu();
            }
        }


    }
}
