package com.tables;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Order {
    private int ordinal;
    private int table;
    private String dish;

    @Override
    public String toString()
    {
        return dish;
    }

    public int getOrdinal()
    {
        return ordinal;
    }

    public void setOrdinal(int ordinal)
    {
        this.ordinal = ordinal;
    }

    public int getTable()
    {
        return table;
    }

    public void setTable(int table)
    {
        this.table = table;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public Order(int ordinal, int table, String dish)
    {
        this.ordinal = ordinal;
        this.table = table;
        this.dish = dish;
    }

    public Order()
    {
    }
}
