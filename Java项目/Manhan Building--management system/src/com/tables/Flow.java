package com.tables;

import java.util.Date;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Flow {
    private int ordinal;
    private int table;
    private String dish;
    private String state;
    private Date time;

    public Flow()
    {
    }

    @Override
    public String toString()
    {
        return ordinal+"\t"+table+"\t"+dish+"    \t"+state + "\t"+time;
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

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public Flow(int ordinal, int table, String dish, String state, Date time)
    {
        this.ordinal = ordinal;
        this.table = table;
        this.dish = dish;
        this.state = state;
        this.time = time;
    }
}
