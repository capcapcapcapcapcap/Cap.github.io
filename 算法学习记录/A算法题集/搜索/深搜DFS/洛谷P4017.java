
import java.io.*;
import java.util.LinkedList;
import java.util.List;


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


    static int n;
    static int m;
    static int mod = 80112002;
    //每个生物的猎物
    static List<Integer>[] eat;
    //每个生物的天敌
    static List<Integer>[] beat;
    //每个生物的链
    static int[] chain;

    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();

        eat = new List[n + 1];
        beat = new List[n + 1];
        for(int i=1;i<=n;i++)
        {
            eat[i]=new LinkedList<>();
            beat[i]=new LinkedList<>();
        }

        chain = new int[n + 1];

        while (m-- > 0)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            beat[a].add(b);
            eat[b].add(a);
        }
        //从顶端开始
        long ans = 0;
        for (int i = 1; i <= n; i++)
        {
            if (beat[i].isEmpty())
                ans = (ans + dfs(i)) % mod;
        }
        out.println(ans);
        out.close();
    }

    static int dfs(int now)
    {
        List<Integer> list = eat[now];
        if (list.isEmpty())
        {
            chain[now]=1;
            return 1;
        }

        int ans = 0;
        for (Integer i : list)
        {
            if(chain[i]!=0)
                ans = (ans + chain[i]) % mod;
            else ans = (ans + dfs(i)) % mod;
        }
        chain[now] = ans;
        return ans;
    }

}
