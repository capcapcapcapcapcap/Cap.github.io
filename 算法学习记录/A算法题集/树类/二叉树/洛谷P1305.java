

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

        int n = in.nextInt();

        String s=in.nextLine();

        Map<Character,Node> map=new HashMap<>();
        Node root=new Node(s.charAt(0));
        map.put(root.value,root);

        if(s.charAt(1)!='*')
        {
            root.left=new Node(s.charAt(1));
            map.put(root.left.value,root.left);
        }
        if(s.charAt(2)!='*')
        {
            root.right=new Node(s.charAt(2));
            map.put(root.right.value,root.right);
        }
        while (n-- > 1)
        {
            s=in.nextLine();
            Node now=map.get(s.charAt(0));
            if(s.charAt(1)!='*')
            {
                now.left=new Node(s.charAt(1));
                map.put(now.left.value,now.left);
            }
            if(s.charAt(2)!='*')
            {
                now.right=new Node(s.charAt(2));
                map.put(now.right.value,now.right);
            }
        }
        preOrder(root);
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

