package com.vj726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class MainG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++)
        {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int[][] a = new int[4][j + 2];
            for (int m = 0; m < j + 2; m++)
            {
                a[0][m] = -1;
                a[3][m] = -1;
            }
            for (int m = 0; m < 4; m++)
            {
                a[m][0] = -1;
                a[m][j + 1] = -1;
            }
            int lk = 2;
            while (lk > 0)
            {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int k = 1; k < j + 1; k++)
                    a[3 - lk][k] = str.charAt(k - 1) - '0';
                lk--;
            }
            lk = 2;
            boolean flag = true;

            for (int k = 1; k < j + 1; k++)
            {
                lk = 2;
                while (lk > 0)
                {
                    if (a[3 - lk][k] == 1)
                    {
                        if (a[3 - lk][k - 1] == 0)
                            a[3 - lk][k - 1] = -1;
                        else if (a[2 - lk][k] == 0)
                            a[2 - lk][k] = -1;
                        else if (a[4 - lk][k] == 0)
                            a[4 - lk][k] = -1;
                        else if (a[3 - lk][k + 1] == 0)
                            a[3 - lk][k + 1] = -1;

                        else flag = false;
                    }
                    lk--;
                }
            }

            if (flag)
                System.out.println("RP");
            else System.out.println("++");
        }

    }
}
