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


    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        String str = in.nextLine();
        while (!("END").equals(str))
        {
            int len = str.length();
            int ASC = 8 * len;

            //计算各字符权重
            char[] a = str.toCharArray();
            Map<Character, Integer> W = new HashMap();
            for (char now : a)
            {
                if (W.containsKey(now))
                    W.put(now, W.get(now) + 1);
                else W.put(now, 1);
            }


            /*  构造哈夫曼树，获得哈夫曼编码
             *  规定左为0,右为1
             */
            List<Node> tree = new LinkedList();

            for (Character now : W.keySet())
                tree.add(new Node(now, W.get(now)));


            while (tree.size() > 1)
            {
                Collections.sort(tree);
                Node fir = tree.get(0);
                Node sec = tree.get(1);
                Node fa = new Node(null, fir.weight + sec.weight);
                fa.left = fir;
                fa.right = sec;
                tree.remove(fir);
                tree.remove(sec);
                tree.add(fa);

            }

            //  开始编码
            Node root = tree.get(0);
            Queue<Code> C=new LinkedList();
            C.offer(new Code(root,new String()));
            Map<Character,String> huffman=new HashMap();

            while(!C.isEmpty())
            {
                Code now=C.poll();
                root=now.val;
                String s=now.code;
                //先存储当前字符编码
                if(root.value!=null)
                    huffman.put(root.value,s);

                //接着处理 左右子节点的编码
                Node left=root.left;
                Node right=root.right;
                if(left!=null)
                    C.offer(new Code(left,s+"0"));
                if(right!=null)
                    C.offer(new Code(right,s+"1"));

            }

            if(W.size()==1)
                huffman.put(root.value,"1");
            //生成语句对应的哈夫曼编码
            StringBuilder ans=new StringBuilder();
            for (Character now : a)
                ans.append(huffman.get(now));

            int HUFF=ans.length();
            double ANS=1.0*ASC/HUFF;
            out.print(ASC+" ");
            out.print(HUFF+" ");
            out.printf("%.1f",ANS);
            out.println();
            str = in.nextLine();
        }
        out.close();
    }

    static class Node implements Comparable<Node> {
        Character value;
        int weight;
        Node left;
        Node right;

        public Node(Character value, int weight)
        {
            this.value = value;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o)
        {
            return this.weight - o.weight;
        }
    }

    static class Code
    {
        Node val;
        String code;

        public Code(Node val, String code)
        {
            this.val = val;
            this.code = code;
        }
    }

}