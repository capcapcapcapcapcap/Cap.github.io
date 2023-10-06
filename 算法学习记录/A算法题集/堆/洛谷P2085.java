
import java.io.*;
import java.util.*;

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
        int m = in.nextInt();


        PriorityQueue<Long> ans = new PriorityQueue<>();
        PriorityQueue<Long> max=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            for (int j = 1; j <= m; j++)
            {
                long temp = (long) j * j * a + (long) j * b + c;
                if (ans.size() < m)
                {
                    ans.add(temp);
                    max.add(temp);
                }
                else if(temp<max.peek())
                {
                    ans.add(temp);
                    max.poll();
                    max.add(temp);
                }
                else break;

            }
        }
        for (int i = 0; i < m; i++)
            out.print(ans.poll() + " ");

        out.close();
    }
}