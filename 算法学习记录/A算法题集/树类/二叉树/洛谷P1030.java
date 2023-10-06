

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
    static String preOrder;
    static String midOrder;
    static String postOrder;

    public static void main(String[] args)
    {
        FastReader in = new FastReader();

        midOrder = in.nextLine();
        postOrder = in.nextLine();
        Node root = new Node(postOrder.charAt(postOrder.length() - 1));

        int len = midOrder.length();

        preOrder(rebuild(len));
        out.close();
    }

    public static Node rebuild(int len)
    {
        if (midOrder == null || postOrder == null || midOrder.length() != postOrder.length())
            return null;
        return build(0, len - 1, 0, len - 1);
    }

    public static Node build(int mid_start, int mid_end, int post_start, int post_end)
    {
        if (mid_start > mid_end || post_start > post_end)
            return null;
        //根据后序遍历确定当前子树的根节点
        char val = postOrder.charAt(post_end);
        Node root = new Node(val);

        //找出根节点在中序遍历中的位置
        int root_index = midOrder.indexOf(val);

        //计算左子树的长度(右子树长度可 以其表示)
        int left_size = root_index - mid_start;

        //以递归重建当前根节点的左右子树(因为最初的遍历序列即通过递归得来)
        root.left = build(mid_start, root_index - 1, post_start, post_start + left_size - 1);
        root.right = build(root_index + 1, mid_end, post_start + left_size, post_end - 1);
        return root;
    }

    //前序遍历
    public static void preOrder(Node root)
    {
        if(root==null)
            return;
        out.print(root.value);
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value)
        {
            this.value = value;
        }
    }


}
