package com.HousingRentalSystem;

import java.util.ArrayList;

/**
 * The type House.
 * 1.一个 House 的对象表示一个房屋信息
 */
public class House {
    /**
     * The constant houses.
     */
    /*建立一个房屋列表*/
    public static final ArrayList<House> houses = new ArrayList<>();
    /**
     * 编号 房主 电话 地址 月租 状态（未出租/已出租）
     */
    private int id;
    private String houseOwner;
    private String phone;
    private String address;
    private String rent;
    private String state;

    /**
     * Instantiates a new House.
     *
     * @param id         the id
     * @param houseOwner the house owner
     * @param phone      the phone
     * @param address    the address
     * @param rent       the rent
     * @param state      the state
     */
    public House(int id, String houseOwner, String phone, String address, String rent, String state)
    {
        this.id = id;
        this.houseOwner = houseOwner;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    /**
     * Gets .
     *
     * @param id the id
     * @return the
     */
    public static String gethouse(int id)
    {
        for (House a : houses)
        {
            if (a.getId() == id) return a.toString();
        }
        return "查无此屋";

    }

    /**
     * Remove.
     *
     * @param id the id
     */
    public static void remove(int id)
    {
        for (House a : houses)
        {
            if (a.getId() == id)
            {
                houses.remove(a);
                System.out.println("你已成功删除该房源");
                break;
            }
        }
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Gets house owner.
     *
     * @return the house owner
     */
    public String getHouseOwner()
    {
        return houseOwner;
    }

    /**
     * Sets house owner.
     *
     * @param houseOwner the house owner
     */
    public void setHouseOwner(String houseOwner)
    {
        this.houseOwner = houseOwner;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Gets rent.
     *
     * @return the rent
     */
    public String getRent()
    {
        return rent;
    }

    /**
     * Sets rent.
     *
     * @param rent the rent
     */
    public void setRent(String rent)
    {
        this.rent = rent;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return id + "\t" + houseOwner + "\t" + phone + "\t" + address + "\t" + rent + "\t\t" + state;
    }
}
