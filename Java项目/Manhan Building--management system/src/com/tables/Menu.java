package com.tables;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Menu {
    private int ordinal;
    private String name;
    private int price;
    private String type;

    @Override
    public String toString()
    {
        return name+"  \t"+price+"\t"+ type+"\t";
    }

    public Menu(int ordinal, String name, int price, String type)
    {
        this.ordinal = ordinal;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Menu()
    {
    }

    public int getOrdinal()
    {
        return ordinal;
    }

    public void setOrdinal(int ordinal)
    {
        this.ordinal = ordinal;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
