
import java.io.*;
import java.util.*;


public class 洛谷P1219 {
    static int n;
    static boolean[] col;
    static boolean[] rc1;
    static boolean[] rc2;
    static int ans=0;
    static int[] a;
    static int time = 3;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        col = new boolean[n + 1];
        rc1 = new boolean[2 * n];
        rc2 = new boolean[2 * n];
        a=new int[n];
        dfs(1);
        System.out.println(ans);

    }

    static void dfs(int i)
    {

        //列
        if(i>n)
        {
            if(time>0)
            {
                for (int aa : a)
                    System.out.print(aa + " ");
                System.out.println();

            }
            ans++;
            time--;
            return;
        }
        for (int j = 1; j <= n; j++)
        {
            if (!col[j] && !rc1[j - i + n] && !rc2[i + j - 1])
            {
                a[i-1]=j;

                col[j] = true;
                rc1[j-i + n] = true;
                rc2[i + j - 1] = true;
                dfs(i+1);
                col[j] = false;
                rc1[j-i + n] = false;
                rc2[i + j - 1] = false;
            }
        }

    }
}