Utility.javapackage com.common;

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
        return in.nextInt();
    }
    public static char InChar()
    {
        return in.next().charAt(0);
    }

    public static String InString()
    {
        return in.next();
    }

    public static int Inid()
    {
        System.out.print("Enter id: ");
        return in.nextInt();
    }


    /**
     * Inchoice boolean.
     *
     * @return the boolean
     */
    public static boolean Inchoice()
    {
        System.out.print("是否确认退出 (y/n) ：");
        return "y".equals(in.next());
    }

    /**
     * Inoption int.
     *
     * @return the int
     */
    public static int Inoption()
    {
        System.out.print("请选择: ");
        return in.nextInt();
    }
}
