
import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        public StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in), 32768));
        public int nextInt() throws IOException
        {
            in.nextToken();
            return (int) in.nval;
        }

    }

    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        //p=u/v
        int u = in.nextInt();
        int v = in.nextInt();
        final double p=1.0*u/v;
        int t = in.nextInt();
        //原蚯蚓队列
        PriorityQueue<Integer> list=new PriorityQueue<>(Collections.reverseOrder());

        //切割蚯蚓队列
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        for (int k = 1; k <= n; k++)
            list.offer(in.nextInt());

        int sum = 0;
        for (int j = 1; j <= m; j++)
        {
            int now = Integer.MIN_VALUE;
            Queue<Integer> maxque=null;
            if (!list.isEmpty() && list.peek() > now)
            {
                now = list.peek();
                maxque=list;
            }
            if (!left.isEmpty() && left.peek() > now)
            {
                now = left.peek();
                maxque=left;
            }
            if (!right.isEmpty() && right.peek() > now)
            {
                now = right.peek();
                maxque=right;
            }
            maxque.poll();
            now += sum;
            if (j % t == 0)
                out.write(now + " ");

            sum += q;
            int l = (int) (now * p);
            int r = now - l;
            left.add(l - sum);
            right.add(r - sum);

        }
        out.newLine();
        /*
         * !!!下面的代码很关键:
         * 倘如将三个队列直接合并后排序,时间复杂度为O(logn),会超时
         * 因此,仍按照上面切割的思路输出蚯蚓长度
         */

        for (int j = 1; j<=n+m; j++)
        {
            int now = Integer.MIN_VALUE;
            Queue<Integer> maxque=null;
            if (!list.isEmpty() && list.peek() > now)
            {
                now = list.peek();
                maxque=list;
            }
            if (!left.isEmpty() && left.peek() > now)
            {
                now = left.peek();
                maxque=left;
            }
            if (!right.isEmpty() && right.peek() > now)
            {
                now = right.peek();
                maxque=right;
            }
            maxque.poll();
            if (j % t == 0)
                out.write(now + sum + " ");
        }
        out.flush();
        out.close();
    }
}