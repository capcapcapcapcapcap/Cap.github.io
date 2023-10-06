
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

    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args)
    {
        FastReader in = new FastReader();


        int n = in.nextInt();
        String str = in.nextLine();

        Queue<Node> tree = new LinkedList<>();
        Node root = new Node(check(str), str);
        Node tmp=root;
        tree.offer(root);

        while (!tree.isEmpty())
        {
            root = tree.poll();

            int len = root.value.length();
            if (len > 1)
            {
                String l = root.value.substring(0, len / 2);
                String r = root.value.substring((len / 2));

                root.left = new Node(check(l), l);
                root.right = new Node(check(r), r);
                tree.offer(root.left);
                tree.offer(root.right);
            }
        }

        postOrder(tmp);
        out.close();
    }

    //后序遍历
    public static void postOrder(Node root)
    {
        if(root.left!=null)
            postOrder(root.left);

        if(root.right!=null)
            postOrder(root.right);
        out.print(root.type);

    }
    static class Node {
        char type;
        String value;
        Node left;
        Node right;

        public Node(char type, String value)
        {
            this.type = type;
            this.value = value;
        }
    }

    static char check(String str)
    {
        if (str.contains("0"))
        {
            if (str.contains("1"))
                return 'F';
            else return 'B';
        } else return 'I';
    }

}
