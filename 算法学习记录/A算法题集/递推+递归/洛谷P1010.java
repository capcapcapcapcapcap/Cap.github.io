import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 洛谷P1010{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        f(n);
    }

    static void f(int x)
    {
        for (int i = 14; i >= 0; i--)
        {
            if (Math.pow(2, i) <= x)
            {
                if (i == 1)
                    System.out.print("2");
                else if (i == 0)
                    System.out.print("2(0)");
                else
                {
                    System.out.print("2(");
                    f(i);
                    System.out.print(")");
                }
                x -= Math.pow(2, i);
                if (x != 0)
                    System.out.print("+");
            }
        }
    }
}