package com.utilities;

import java.util.Scanner;

/**
 * The type Utility.
 */
public class IO_Utility {
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
        int i = Integer.parseInt(in.nextLine());
        return i;
    }

    public static char InChar()
    {
        return in.nextLine().charAt(0);
    }

    public static String InString()
    {
        return in.nextLine();
    }




    /**
     * Inchoice boolean.
     *
     * @return the boolean
     */
    public static boolean Inchoice()
    {
        return "y".equals(in.nextLine());
    }

    /**
     * Inoption int.
     *
     * @return the int
     */
    public static int Inoption()
    {
        System.out.print("请选择: ");
        int i = Integer.parseInt(in.nextLine());
        return i;
    }

    public static void rollback()
    {
        System.out.print("按任意键返回: ");
        IO_Utility.InChar();
    }
}
