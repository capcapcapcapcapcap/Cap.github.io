package com.tables;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Bill {
    private String dish;
    private int price;

    @Override
    public String toString()
    {
        return dish+"\t\t\t---"+ price+" 元";
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public Bill()
    {
    }

    public Bill(String dish, int price)
    {
        this.dish = dish;
        this.price = price;
    }
}
