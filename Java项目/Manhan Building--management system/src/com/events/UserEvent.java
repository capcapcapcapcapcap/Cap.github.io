package com.events;

import com.daos.BasicDao;
import com.tables.*;
import com.utilities.IO_Utility;

import java.sql.Connection;
import java.util.List;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class UserEvent {
    public static void tableStatus()
    {
        System.out.println("-------------当前满汉楼餐桌状态-------------");
        String sql = "select * from diningTable";
        List<DiningTable> dts = BasicDao.selectMulti(sql, DiningTable.class);
        int i = 1;
        for (DiningTable dt : dts)
        {
            System.out.print(dt + "\t\t\t");
            if ((i++) % 2 == 0)
                System.out.println();
        }
        System.out.println("--------------------------------------");

    }

    public static void book()
    {
        System.out.println("-------------欢迎预定满汉楼餐桌-------------");
        tableStatus();

        String sql1 = "select state from diningtable where ordinal=?";
        System.out.print("请输入您要预定的餐桌编号: ");
        int ordinal = IO_Utility.InInt();
        String state = (String) BasicDao.selectOne(sql1, ordinal);

        //录入预定信息
        if ("未预定".equals(state))
        {
            System.out.println(ordinal + "号餐桌选定成功!请您填写相关预定信息...");

            System.out.print("预定人姓名: ");
            String name = IO_Utility.InString();
            System.out.print("预定人电话: ");
            String phone = IO_Utility.InString();
            System.out.print("预定就餐时间: ");
            String time = IO_Utility.InString();
            System.out.print("请问是否确认预定(y/n): ");
            boolean b = IO_Utility.Inchoice();
            if (b)
            {
                String sql2 = "update diningtable set state=?,orderer=?,orderTel=?,time=? where ordinal=?";
                BasicDao.update(sql2, "已预定", name, phone, time, ordinal);
                System.out.println("恭喜!您已成功预定" + ordinal + "号餐桌,请您在预定时间前来就餐...");
                IO_Utility.rollback();
            } else
            {
                System.out.print("已取消预定,");
                IO_Utility.rollback();
            }
        } else
        {
            System.out.println("抱歉," + ordinal + "号餐桌已被预定!请您重新选择餐桌...");
            book();
        }
    }

    public static void menu()
    {
        String sql = "select * from menu order by type,price";
        List<Menu> menus = BasicDao.selectMulti(sql, Menu.class);
        System.out.println("------------------满汉楼菜单-----------------");
        System.out.println("  菜 名\t\t价 格\t类 型\t菜 名\t\t价 格\t类 型");
        int i = 1;
        for (Menu menu : menus)
        {
            System.out.print(menu);
            if ((i++) % 2 == 0)
                System.out.println();
        }
        System.out.println("--------------------------------------");
    }

    public static void order()
    {
        System.out.println("------------欢迎点餐!!!---------------");
        //确认点餐餐桌
        System.out.print("请输入您的餐桌号: ");
        int ordinal = IO_Utility.InInt();
        String sql1 = "select state from diningtable where ordinal=?";
        String state = (String) BasicDao.selectOne(sql1, ordinal);
        if ("未预定".equals(state))
        {
            System.out.println("抱歉," + ordinal + "号餐桌未被预定,请先预定餐桌再继续点餐...");
            book();
            order();
        }
        //开始点餐
        else
        {
            menu();
            System.out.print("请问是否开始点餐(y/n): ");
            if (!IO_Utility.Inchoice())
                return;
            String sql = "select * from menu where replace(name,' ','') like ?";

            do
            {
                System.out.print("请输入菜名: ");
                String name = IO_Utility.InString();
                Menu menu = BasicDao.selectSingle(sql, Menu.class, name);
                System.out.println("  菜 名\t\t价 格\t类 型");
                System.out.println(menu);
                System.out.print("请问是否选择此菜品(y/n): ");
                if (IO_Utility.Inchoice())
                {
                    System.out.print("请选择菜品份数: ");
                    int i = IO_Utility.InInt();
                    String sql2 = "insert into `order`(`table`,dish) value(?,?)";
                    for (int j = 0; j < i; j++)
                        BasicDao.update(sql2, ordinal, name);
                    System.out.println(ordinal + "号餐桌," + name + " " + i + " 份!");
                }
                System.out.print("请问是否继续点餐(y/n): ");
            } while (IO_Utility.Inchoice());
            //显示选择的所有菜品
            System.out.println(ordinal + "号餐桌已选择的菜品有:");
            String sql3 = "select distinct `dish` from `order` where `table`=? and `state`='未付款'";
            List<Order> orders = BasicDao.selectMulti(sql3, Order.class, ordinal);
            String sql4="update diningtable set `state`='就餐中' where ordinal=?";
            BasicDao.update(sql4, ordinal);
            int i = 1;
            for (Order order : orders)
            {
                System.out.print(order + "\t");
                if ((i++) % 5 == 0)
                    System.out.println();
            }
            System.out.println("\n祝您用餐愉快!");
            IO_Utility.rollback();
        }
    }

    public static void bill(int ordinal)
    {
        System.out.println("---------------账单---------------");

        String sql = "select `dish`,`price` from `order`,`menu` where `table`=? and state='未付款' and REPLACE (`menu`.`name`,' ', '')=`order`.`dish`order by `price`";

        List<Bill> bills = BasicDao.selectMulti(sql, Bill.class, ordinal);
        int total = 0;
        for (Bill bill : bills)
        {
            System.out.println(bill);
            total += bill.getPrice();
        }
        System.out.println("总 计:\t\t\t---" + total + " 元");
    }


    public static void Checkout()
    {
        System.out.println("---------------账单---------------");
        //确认点餐餐桌
        System.out.print("请输入您的餐桌号: ");
        int ordinal = IO_Utility.InInt();
        String sql = "select state from diningtable where ordinal=?";
        String state = (String) BasicDao.selectOne(sql, ordinal);
        if ("未预定".equals(state))
        {
            System.out.println("抱歉," + ordinal + "号餐桌未被预定,请先预定餐桌再继续结账...");
            book();
        } else
            bill(ordinal);
        System.out.print("请问是否付款(y/n): ");
        if (IO_Utility.Inchoice())
        {
            System.out.println("请选择付款方式:");
            System.out.println("1.现金支付  2.POS支付  3.扫码支付");
            IO_Utility.Inoption();

            //结账事务
            String sql1 = "update `order` set state='已付款' where `table`=?";
            String sql2 = "update diningtable set state='未预定',orderer=null,orderTel=null,time=null where `ordinal`=?";

            Connection con=BasicDao.start();
            BasicDao.execute(con,sql1, ordinal);
            BasicDao.execute(con,sql2,ordinal);
            BasicDao.commit(con);

            System.out.println("支付成功!欢迎下次光临满汉楼餐厅...");
            IO_Utility.rollback();
        }
    }

    public static boolean quit()
    {
        System.out.print("请问是否确认退出用户菜单(y/n): ");
        return !IO_Utility.Inchoice();
    }
}
