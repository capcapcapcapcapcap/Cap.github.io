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
        char value;
        Node left;
        Node right;

        public Node(char value)
        {
            this.value = value;
        }

        public Node()
        {
        }
    }

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args)
    {
        FastReader in = new FastReader();

        String pre=in.nextLine();
        String post=in.nextLine();
        char[] a=pre.toCharArray();
        char[] b=post.toCharArray();

        long ans=1;
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=1;j<b.length;j++)
                if(a[i]==b[j]&&a[i+1]==b[j-1])
                    ans*=2;
        }
        out.println(ans);
        out.close();
    }
    public static void preOrder(Node root)
    {
        if(root==null)
            return;
        out.print((char)root.value);
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }
}

