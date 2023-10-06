
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
        FastReader in=new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int n=in.nextInt();
        while(n-->0)
        {
            int op=in.nextInt();
            switch (op)
            {
                case 1:
                    int x=in.nextInt();
                    heap.add(x);
                    break;
                case 2:
                    out.println(heap.peek());
                    break;
                case 3:
                    heap.poll();
                    break;
            }
        }
        out.close();
    }
}


