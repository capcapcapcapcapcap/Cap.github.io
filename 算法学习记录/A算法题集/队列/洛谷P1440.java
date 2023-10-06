

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  单调队列滑动窗口问题
 */
public class Main {
    static class FastReader {
        public StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));

        public double nextDouble() throws IOException
        {
            in.nextToken();
            return in.nval;
        }

        public float nextFloat() throws IOException
        {
            in.nextToken();
            return (float) in.nval;
        }

        public int nextInt() throws IOException
        {
            in.nextToken();
            return (int) in.nval;
        }

        public String next() throws IOException
        {
            return in.sval;
        }

        public long nextLong() throws Exception
        {
            in.nextToken();
            return (long) in.nval;
        }
    }


    public static void main(String[] args) throws IOException
    {
        FastReader in=new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] a=new int[n+1];
        for (int i = 1; i <=n ; i++)
        {
            a[i]=in.nextInt();
        }

        Deque<Integer> q=new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
        {
            while(!q.isEmpty()&&q.peek()<i-m)
                q.poll();

            if(q.isEmpty())
                out.println("0");
            else if(q.peek()>=i-m)
            {
                out.println(a[q.peek()]);
                while (!q.isEmpty() && a[q.peekLast()] > a[i])
                    q.pollLast();
            }
            q.offer(i);
        }
        out.close();
    }
}