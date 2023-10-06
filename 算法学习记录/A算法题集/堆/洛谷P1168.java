

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
        int[] A = new int[n + 1];
        A[1] = in.nextInt();
        //中位数mid
        int mid = A[1];
        out.println(mid);
        //中位数左侧的大根堆
        Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(maxHeapComparator);

        //中位数右侧的小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int u = 2; u <= n; u++)
        {
            A[u] = in.nextInt();
            if (A[u] > mid)
                minHeap.add(A[u]);
            else maxheap.add(A[u]);
            if (u % 2 == 1)
            {
                while (maxheap.size() != minHeap.size()) //mid不再是中位
                {
                    if (maxheap.size() > minHeap.size())
                    {
                        minHeap.add(mid);
                        mid = maxheap.poll();
                    } else
                    {
                        maxheap.add(mid);
                        mid = minHeap.poll();
                    }
                }
                out.println(mid);
            }
        }
        out.close();

    }
}

