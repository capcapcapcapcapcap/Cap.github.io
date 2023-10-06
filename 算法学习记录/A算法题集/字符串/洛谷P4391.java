

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


    public static void main(String[] args)
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        String str = in.nextLine();
        char[] b=str.toCharArray();
        char[] a = new char[1000001];
        int[] next=new int[n+10];
        for(int i=1;i<=n;i++)
            a[i]=b[i-1];

        int j;
        for (int i = 2; i <= n; i++)
        {
            j = next[i - 1];
            while (j != 0 && a[j + 1] != a[i])
                j = next[j];
            if (a[j + 1] == a[i])
                j++;
            next[i] = j;
        }
        out.println(n-next[n]);
        out.close();
    }
}