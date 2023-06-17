package com.HousingRentalSystem;

/**
 * The type House rental app.
 * 1.创建 HouseView 对象，显示主界面
 */
public class HouseRentalApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        HouseView houseView1 = new HouseView();

        System.out.println("---------欢迎使用CAP-房屋出租系统！！！--------");
        System.out.println("---------欢迎使用CAP-房屋出租系统！！！--------");
        System.out.println("---------欢迎使用CAP-房屋出租系统！！！--------");
        System.out.println("--------请按照提示操作--------");

        do
        {
            houseView1.mainMenu();
            houseView1.OptionsMenu();
        } while (houseView1.isLoop());
    }
}
