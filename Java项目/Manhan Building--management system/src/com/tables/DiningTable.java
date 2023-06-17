package com.tables;

import java.util.Date;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class DiningTable {
    private int ordinal;
    private String state;
    private String name;
    private String phone;
    private Date time;
    public DiningTable(){}

    public DiningTable(int ordinal, String state, String name, String phone)
    {
        this.ordinal = ordinal;
        this.state = state;
        this.name = name;
        this.phone = phone;
    }

    public int getOrdinal()
    {
        return ordinal;
    }

    public void setOrdinal(int ordinal)
    {
        this.ordinal = ordinal;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return ordinal+"号餐桌: "+state;
    }
}
