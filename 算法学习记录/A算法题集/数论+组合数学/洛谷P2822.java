

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int k;

    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(System.out);
        FastReader in = new FastReader();
        int t = in.nextInt();
        k = in.nextInt();
        int[][] dp = new int[2000 + 1][2000 + 1];
        for (int i = 0; i <= 2000; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    dp[i][j] = 1 % k;
                } else
                {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % k;
                }
            }
        }
        int[][] ans = new int[2002][2002];
        for (int i = 2; i <= 2000; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                //上+左-左上
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1];
                //+自己
                if (dp[i][j] == 0)
                    ans[i][j]++;
            }
            ans[i][i + 1] = ans[i][i];
        }
        while (t-- > 0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            m = Math.min(m, n);

            out.println(ans[n][m]);
        }
        out.close();
    }


}