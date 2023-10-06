

import java.io.*;
import java.util.*;

/*
 *  多叉哈夫曼树
*/
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

    static class Node implements Comparable<Node> {
        long value;
        int high;
        Node left;
        Node right;

        public Node(long value, int high)
        {
            this.value = value;
            this.high = high;
        }

        @Override
        public int compareTo(Node o)
        {
            if (this.value == o.value)
                return this.high - o.high;
            else if (this.value < o.value)
                return -1;
            else return 1;
        }
    }

    static int ans = 1;
    static PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args)
    {
        FastReader in = new FastReader();

        long n = in.nextLong();
        long k = in.nextLong();

        PriorityQueue<Node> tree1 = new PriorityQueue<>();
        for (int u = 1; u <= n; u++)
            tree1.add(new Node(in.nextLong(), 0));

        long ans = 0;
        int len = 0;
        /*
         *  首先，我们每次合并用掉k个节点又合并出1个节点，那么按每次合并来算，我们每次用掉k-1个节点
         *  然后，我们最终需要只剩1个根节点，即需要合并n-1个初始节点。
         *  因此，要求(n-1)%(k-1)=0,否则需要先补充(k-1)-((n-1)%(k-1))个权重为0的初始节点，辅助合并。
         */
        if ((n - 1) % (k - 1) != 0)
        {
            int more = (int) ((k - 1) - (n - 1) % (k - 1));
            for (int u = 1; u <= more; u++)
                tree1.offer(new Node(0, 0));
        }

        while (tree1.size() > 1)
        {
            long temp = 0;
            int high = 0;
            for (int j = 1; j <= k; j++)
            {
                if (tree1.size() > 0)
                {
                    high = Math.max(high, tree1.peek().high);
                    temp += tree1.poll().value;
                }

            }

            ans += temp;
            tree1.offer(new Node(temp, high + 1));
        }
        len = tree1.poll().high;
        out.println(ans);
        out.println(len);
        out.close();
    }
}

