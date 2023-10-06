import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调队列与最大子序和问题
 * dp队列记录区间头尾,通过前缀和数组计算区间和
 * 该思路可转化为尺取法
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
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();

        //前缀和数组
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            a[i] = in.nextInt()+a[i-1];
        }

        Deque<Integer> dp = new ArrayDeque<>();
        int ans=0;
        for (int i = 1; i <= n; i++)
        {
            while (!dp.isEmpty() && dp.peek() < i - m)
                dp.poll();

            if(dp.isEmpty())
                ans=Math.max(ans,a[i]);
            else ans=Math.max(ans,a[i]-a[dp.peek()]);

            //若区间和q.peekLast()~i<0,则向前推移区间头,
            while (!dp.isEmpty() && a[i]-a[dp.peekLast()]<0)
                dp.pollLast();
            dp.offer(i);

        }
        out.println(ans);
        out.close();
    }
}