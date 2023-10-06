
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

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value)
        {
            this.value = value;
        }

    }

    static int ans=1;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args)
    {
        FastReader in = new FastReader();

        int n=in.nextInt();
        Map<Integer,Node> tree=new HashMap<>();

        for (int u = 1; u <= n; u++)
            tree.put(u, new Node(in.nextInt()));

        for (int u = 1; u <= n; u++)
        {
            int l=in.nextInt();
            int r=in.nextInt();
            if(l!=-1)
                tree.get(u).left=tree.get(l);
            if(r!=-1)
                tree.get(u).right=tree.get(r);
        }

        int temp=0;
        for (Integer now : tree.keySet())
        {
            ans=1;
            if(equal(tree.get(now).left,tree.get(now).right))
                temp=Math.max(temp,ans);
        }
        out.println(temp);
        out.close();
    }

    public static boolean equal(Node a,Node b)
    {
        if(a==null&&b==null)
            return true;
        if(a==null||b==null)
            return false;
        if(a.value==b.value)
        {
            ans+=2;
            return equal(a.right,b.left)&&equal(a.left,b.right);
        }

        return false;
    }

}

