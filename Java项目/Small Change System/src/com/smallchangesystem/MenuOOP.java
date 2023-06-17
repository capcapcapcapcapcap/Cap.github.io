package com.smallchangesystem;

import java.util.Scanner;

/**
 * The type Menu oop.
 */
public class MenuOOP {
    /**
     * The In.
     */
    Scanner in = new Scanner(System.in);
    private boolean flag = true;

    /**
     * Is flag boolean.
     *
     * @return the boolean
     */
    public boolean isFlag()
    {
        return flag;
    }

    /**
     * Initial menu.
     */
    public void InitialMenu()
    {
        System.out.println("=============零钱通菜单==============\n");
        System.out.println("\t\t1.\t 零钱通明细");
        System.out.println("\t\t2.\t 转入");
        System.out.println("\t\t3.\t 转出");
        System.out.println("\t\t4.\t 退出");
        System.out.print("请选择：");
    }

    /**
     * Options.
     *
     * @param option  the option
     * @param account the account
     */
    public void Options(int option, Account account)
    {
        switch (option)
        {
            case 1 -> DetailOption(account);
            case 2 -> InOption(account);
            case 3 -> OutOption(account);
            case 4 -> QuitOption();

            default -> System.out.println("输入错误，请重新输入");
        }
    }

    /**
     * Detail option.
     *
     * @param account the account
     */
    public void DetailOption(Account account)
    {
        System.out.println("=============零钱通明细==============\n");
        System.out.println("总余额：" + account.getBalance());

        for (String str : account.getRecords())
        {
            System.out.println(str);
        }
    }

    /**
     * In option.
     *
     * @param account the account
     */
    public void InOption(Account account)
    {
        System.out.println("=============转入==============\n");
        System.out.print("请输入转入金额： ");
        account.setMoney();
        account.Income();
    }

    /**
     * Out option.
     *
     * @param account the account
     */
    public void OutOption(Account account)
    {
        System.out.println("=============转出==============\n");
        System.out.print("请输入交易事项： ");
        account.setTransaction();
        System.out.print("\n请输入转出金额： ");
        account.setMoney();
        if (account.getMoney() <= account.getBalance())
        {
            account.Expenditure();
        } else
        {
            System.out.println("余额不足\n目前账户余额：" + account.getBalance());
        }

    }

    /**
     * Quit option.
     */
    public void QuitOption()
    {
        System.out.print("请确认是否退出（y/n）：");
        String choice = in.next();
        if ("y".equals(choice))
        {
            flag = false;
            System.out.println("已退出，感谢使用 零钱通 ！");
        }
    }
}
