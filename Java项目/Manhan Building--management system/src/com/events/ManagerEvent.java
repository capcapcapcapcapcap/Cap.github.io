package com.events;

import com.daos.BasicDao;
import com.tables.Flow;
import com.utilities.IO_Utility;

import java.util.List;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class ManagerEvent {
    public static void updateStatus()
    {
        UserEvent.tableStatus();
        System.out.println("$管理者仅可将餐桌状态更改为'未预定'$");
        System.out.print("请输入要更改的餐桌编号: ");
        int ordinal = IO_Utility.InInt();
        String sql = "update `diningtable` set state='未预定',orderer=null, orderTel=null,time=null where ordinal=?";
        BasicDao.update(sql, ordinal);
        System.out.print(ordinal + " 号餐桌状态已更改,请问是否继续修改(y/n): ");
        if (IO_Utility.Inchoice())
            updateStatus();
    }

    public static void addMenu()
    {
        System.out.print("请输入要添加的菜品名称: ");
        String name = IO_Utility.InString();
        System.out.print("请输入要添加的菜品价格: ");
        int price = IO_Utility.InInt();
        System.out.print("请输入要添加的菜品类型: ");
        String type = IO_Utility.InString();

        String sql = "insert into `menu`(name,price,type) value(?,?,?)";
        BasicDao.update(sql, name, price, type);
        System.out.print("菜品已添加,请问是否继续添加(y/n): ");
        if (IO_Utility.Inchoice())
            addMenu();
    }

    public static void deleteMenu()
    {
        System.out.print("请输入要删除的菜品名称: ");
        String name = IO_Utility.InString();

        String sql = "delete from `menu` where replace(name,' ','')=?";
        BasicDao.update(sql, name);
        System.out.print("菜品已删除,请问是否继续删除(y/n): ");
        if (IO_Utility.Inchoice())
            addMenu();
    }

    public static void updateMenu()
    {
        System.out.print("请输入要更改的菜品名称: ");
        String name = IO_Utility.InString();
        System.out.println("请选择要更改的菜品内容: ");
        System.out.println("1. 菜 名");
        System.out.println("2. 价 格");
        System.out.println("3. 类 型");
        int i = IO_Utility.Inoption();
        switch (i)
        {
            case 1 ->
            {
                System.out.print("请输入要更改的菜名: ");
                String name2 = IO_Utility.InString();
                String sql = "update `menu` set `name`=? where replace(`name`,' ','')=?";
                BasicDao.update(sql, name2, name);
            }
            case 2 ->
            {
                System.out.print("请输入要更改的价格: ");
                int price = IO_Utility.InInt();
                String sql = "update `menu` set price=? where replace(`name`,' ','')=?";
                BasicDao.update(sql, price, name);
            }
            case 3 ->
            {
                System.out.print("请输入要更改的类型: ");
                String type = IO_Utility.InString();
                String sql = "update `menu` set `type`=? where replace(`name`,' ','')=?";
                BasicDao.update(sql, type, name);
            }

        }
        System.out.print("菜品信息已更改,请问是否继续更改(y/n): ");
        if (IO_Utility.Inchoice())
            updateMenu();
    }

    public static void flow()
    {
        System.out.println("------------------满汉楼 流水-------------------");
        String sql = "select * from `order` order by `table`,`time`";
        List<Flow> flows = BasicDao.selectMulti(sql, Flow.class);
        System.out.println("订单号\t桌号\t 菜品   \t状态\t 下单时间");
        for (Flow flow : flows)
            System.out.println(flow);
        IO_Utility.rollback();
    }

    public static boolean quit()
    {
        System.out.print("请问是否确认退出管理者菜单(y/n): ");
        return !IO_Utility.Inchoice();
    }
}


