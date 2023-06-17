package com.HousingRentalSystem;

import java.util.Scanner;

/**
 * The type Utility.
 */
public class Utility {
    /**
     * The In.
     */
    static Scanner in = new Scanner(System.in);

    /**
     * Inid int.
     *
     * @return the int
     */
    public static int InInt()
    {
        int id = in.nextInt();
        return id;
    }

    public static int Inid()
    {
        System.out.print("Enter id（编号）: ");
        int id = in.nextInt();
        return id;
    }

    /**
     * Inhouse owner string.
     *
     * @return the string
     */
    public static String InhouseOwner()
    {
        System.out.print("Enter houseOwner（房主）: ");
        String houseOwner = in.next();
        return houseOwner;
    }

    /**
     * Inphone string.
     *
     * @return the string
     */
    public static String Inphone()
    {
        System.out.print("Enter phone（电话）: ");
        String phone = in.next();
        return phone;
    }

    /**
     * Inaddress string.
     *
     * @return the string
     */
    public static String Inaddress()
    {
        System.out.print("Enter address（地址）: ");
        String address = in.next();
        return address;
    }

    /**
     * Inrent string.
     *
     * @return the string
     */
    public static String Inrent()
    {
        System.out.print("Enter rent（租金）: ");
        String rent = in.next();
        return rent;
    }

    /**
     * Instate string.
     *
     * @return the string
     */
    public static String Instate()
    {
        System.out.print("Enter state（状态）: ");
        String state = in.next();
        return state;
    }

    /**
     * Inchoice boolean.
     *
     * @return the boolean
     */
    public static boolean Inchoice()
    {
        System.out.print("Enter y/n（是/否）：");
        String choice = in.next();
        return "y".equals(choice);
    }

    /**
     * Inoption int.
     *
     * @return the int
     */
    public static int Inoption()
    {
        System.out.print("Enter option（选项）: ");
        int option = in.nextInt();
        return option;
    }
}
