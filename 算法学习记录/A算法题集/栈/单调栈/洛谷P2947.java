

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
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

    static int N;
    static int[] H;
    public static void main(String[] args)
    {
        FastReader in=new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        N=in.nextInt();
        H=new int[N+1];
        for (int u = 1; u <= N; u++)
        {
            H[u]=in.nextInt();
        }

        int[] ans=new int[N+1];
        Stack<Integer> cow=new Stack<>();
        for(int i=N;i>0;i--)
        {
            while(!cow.isEmpty()&&H[cow.peek()]<=H[i])
                cow.pop();
            if(cow.isEmpty())
                ans[i]=0;
            else ans[i]=cow.peek();
            cow.push(i);
        }
        for (int k = 1; k <= N; k++)
        {
            out.println(ans[k]);
        }
        out.close();
    }
}
