package com.smallchangesystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Account.
 */
public class Account {
    Scanner in = new Scanner(System.in);

    /**
     * The Date.
     */

    /**
     * The Sdf.
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final ArrayList<String> records = new ArrayList<>();
    private String transaction;
    private double money;
    private double balance;

    /**
     * Instantiates a new Account.
     */
    public Account()
    {
        this.balance = 0;
    }

    /**
     * Instantiates a new Account.
     *
     * @param balance the balance
     */
    public Account(double balance)
    {
        this.balance = balance;
    }

    public void setTransaction()
    {
        transaction = in.next();
    }

    public void setMoney()
    {
        this.money = in.nextDouble();
    }

    public double getMoney()
    {
        return money;
    }

    /**
     * Add balance.
     */
    public void addBalance()
    {
        this.balance += this.money;
    }

    /**
     * Sub balance.
     */
    public void subBalance()
    {

        this.balance -= this.money;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance()
    {
        return balance;
    }

    public ArrayList<String> getRecords()
    {
        return records;
    }

    /**
     * Income.
     * 入账
     */
    public void Income()
    {
        this.addBalance();
        records.add(sdf.format(new Date()) + "\n" + "转入金额：\t+" + this.money + "\t目前余额：" + this.getBalance());
        System.out.println(records.get(records.size() - 1));
    }

    /**
     * Expenditure.
     * 支出
     */
    public void Expenditure()
    {
        this.subBalance();
        records.add(sdf.format(new Date()) + "\n" + this.transaction + "：\t-" + this.money + "\t目前余额：" + this.getBalance());
        System.out.println(records.get(records.size() - 1));
    }
}
