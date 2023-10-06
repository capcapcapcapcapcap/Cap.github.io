
import java.io.*;
import java.util.*;


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

    static int k;
    static int n;
    static int m;

    static int[] cow;
    static List<Integer>[] road;
    static Set<Integer>[] farm;
    static boolean[] get;
    static int[] time;

    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        k = in.nextInt();
        n = in.nextInt();
        m = in.nextInt();

        cow = new int[k + 1];
        for (int i = 1; i <= k; i++)
        {
            cow[i] = in.nextInt();
        }

        road = new List[n + 1];
        for (int i = 1; i <= n; i++)
            road[i] = new LinkedList<>();
        while (m-- > 0)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            road[a].add(b);
        }

        farm = new HashSet[n + 1];
        for (int i = 1; i <= n; i++)
        {
            farm[i] = new HashSet<>();
            farm[i].add(i);
        }

        time = new int[n + 1];
        for (int i = 1; i <= k; i++)
        {
            get = new boolean[n + 1];

            int loc = cow[i];
            get[loc] = true;
            dfs(loc);


        }
        int ans = 0;
        for (int now : time)
        {
            if (now >= k)
                ans++;
        }

        out.println(ans);
        out.close();
    }

    static void dfs(int f)
    {
        time[f]++;
        List<Integer> now = road[f];

        for (Integer i : now)
        {
            if (!get[i])
            {
                get[i] = true;
                dfs(i);
            }
        }
    }
}
