package com.HousingRentalSystem;

/**
 * The type House service.
 * 1.响应HouseView类的调用
 * 2.完成对房屋信息的处理（CRUD 增删改查）
 */
public class HouseService {

    private static String tip = "编号\t房主\t电话\t\t地址\t\t\t租金\t\t状态\n";

    /**
     * Add house.
     */
//      编号 房主 电话 地址 月租 状态（未出租/已出租）
    public static void AddHouse()
    {
        System.out.println("------------------- 你正在新增房源······ ---------------------");
        System.out.print("继续新增请按1，取消新增请按7：");
        if (Utility.InInt() == 7)
            return;
        System.out.println("请按照提示，逐步输入房源信息：");
        House.houses.add(new House(Utility.Inid(), Utility.InhouseOwner(), Utility.Inphone(), Utility.Inaddress(), Utility.Inrent(), Utility.Instate()));
        System.out.println("添加房源信息完毕！新房源信息如下：");
        System.out.println(tip + House.houses.get(House.houses.size() - 1));
        System.out.println("");
    }

    /**
     * Delete house.
     */
    public static void DeleteHouse()
    {
        System.out.println("------------------- 你正在删除房源······ ---------------------");
        System.out.print("继续删除请按1，取消删除请按7：");
        if (Utility.InInt() == 7)
            return;
        System.out.println("请输入所要删除房源的编号：");
        int id = Utility.Inid();
        if ("查无此屋".equals(House.gethouse(id)))
        {
            System.out.println("查无此屋！！！");
            DeleteHouse();
        }
        System.out.println("请问你是否确认删除该房源：\n");
        System.out.println(tip + House.gethouse(id));
        if (Utility.Inchoice())
        {
            House.remove(id);
        }
    }

    /**
     * Find house.
     */
    public static void FindHouse()
    {
        System.out.println("------------------- 你正在查找房源······ ---------------------");
        System.out.print("继续查找请按1，取消查找请按7：");
        if (Utility.InInt() == 7)
            return;
        System.out.println("请输入要查找房源的编号：");
        int id = Utility.Inid();
        System.out.println("-----------房源信息-----------\n" + tip + House.gethouse(id));
    }

    /**
     * Change house.
     */
    public static void ChangeHouse()
    {
        System.out.println("-------------------你正在修改房源信息······ ---------------------");
        System.out.print("继续修改请按1，取消修改请按7：");
        if (Utility.InInt() == 7)
            return;
        System.out.println("请输入要修改的房源所属编号：");
        int id = Utility.Inid();
        if ("查无此屋".equals(House.gethouse(id)))
        {
            System.out.println("查无此屋！！！");
            ChangeHouse();
        }
        System.out.println("-----------房源信息-----------\n" + tip + House.gethouse(id));
        System.out.println("----------请选择要修改的信息----------");
        System.out.println("1.编号\n2.房主\n3.电话\n4.地址\n5.月租\n6.状态\n7.退出");
        for (House a : House.houses)
        {
            if (a.getId() == id)
            {
                do
                {
                    switch (Utility.Inoption())
                    {
                        case 1 ->
                        {
                            System.out.println("目前已有的编号：");
                            for (House b : House.houses)
                            {
                                System.out.print(b.getId() + "  ");

                            }
                            System.out.println("\n请勿与已有编号冲突！\n请修改编号：");
                            House.houses.get(id).setId(Utility.Inid());
                        }
                        case 2 -> a.setHouseOwner(Utility.InhouseOwner());
                        case 3 -> a.setPhone(Utility.Inphone());
                        case 4 -> a.setAddress(Utility.Inaddress());
                        case 5 -> a.setRent(Utility.Inrent());
                        case 6 -> a.setState(Utility.Instate());
                        case 7 ->
                        {
                            System.out.println("请问是否确认退出：");
                            if (Utility.Inchoice())
                            {
                                return;
                            }
                        }
                        default ->
                        {
                            System.out.println("选择错误");
                            ChangeHouse();
                        }

                    }
                    System.out.println("请问是否继续修改：");

                } while (Utility.Inchoice());
                System.out.println("----------------修改后的房屋信息------------------");
                System.out.println(tip + House.gethouse(id));
            }
        }

    }

    /**
     * Show house.
     */
    public static void ShowHouse()
    {
        System.out.println("------------------- 你正在查看房源信息列表······ ---------------------");
        System.out.println("-----------房源信息-----------");
        System.out.println(tip);
        for (House a : House.houses)
        {
            System.out.println(a);
        }
    }
}
