
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


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

        char[] a = str.toCharArray();
        Stack<Character> b = new Stack<>();
        boolean flag = true;
        for (char now : a)
        {
            if (now == '@')
                break;
            if (now == '(')
                b.push(now);
            else if (now == ')')
                if (b.isEmpty()||b.pop() != '(')
                {
                    flag = false;
                    break;
                }
        }
        if(!b.isEmpty())
            flag=false;
        if (flag)
            out.println("YES");
        else out.println("NO");
        out.close();
    }
}