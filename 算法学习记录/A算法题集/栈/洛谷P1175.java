

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
        char[] arr = str.toCharArray();

        Stack<Character> op = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char now : arr)
        {
            if (!op.isEmpty())
            {
                switch (now)
                {
                    case '+':
                    case '-':
                    {
                        while (!op.isEmpty() && op.peek() != '(')
                            ans.append(op.pop()).append(" ");
                        break;
                    }
                    case '*':
                    case '/':
                    {
                        while (!op.isEmpty() && op.peek() != '-' && op.peek() != '+' && op.peek() != '(')
                            ans.append(op.pop()).append(" ");
                        break;
                    }
                    case ')':
                    {
                        while (true)
                        {
                            if (op.peek() != '(')
                                ans.append(op.pop()).append(" ");
                            else
                            {
                                op.pop();
                                break;
                            }
                        }
                    }
                }
            }
            if (now >= '0' && now <= '9')
                ans.append(now).append(" ");
            else if (now != ')')
                op.push(now);
        }

        while (!op.isEmpty())
            ans.append(op.pop()).append(" ");
        out.println(ans);
        while (true)
        {
            String[] a = ans.toString().split(" ");
            ans = new StringBuilder();
            boolean flag = false;
            int note = 0;
            int k = 0;
            for (int i = 0; i < a.length; i++)
            {
                String c = (a[i]);
                switch (c)
                {
                    case "+":
                    {
                        int n = Integer.parseInt(a[i - 1]);
                        int m = Integer.parseInt(a[i - 2]);
                        k = n + m;
                        note = i;
                        flag = true;
                        break;
                    }
                    case "-":
                    {
                        int n = Integer.parseInt(a[i - 1]);
                        int m = Integer.parseInt(a[i - 2]);
                        k = m - n;
                        flag = true;
                        note = i;
                        break;
                    }
                    case "*":
                    {
                        int n = Integer.parseInt(a[i - 1]);
                        int m = Integer.parseInt(a[i - 2]);
                        k = m * n;
                        flag = true;
                        note = i;
                        break;
                    }
                    case "/":
                    {
                        int n = Integer.parseInt(a[i - 1]);
                        int m = Integer.parseInt(a[i - 2]);
                        k = m / n;
                        flag = true;
                        note = i;
                        break;
                    }
                    case "^":
                    {
                        int n = Integer.parseInt(a[i - 1]);
                        int m = Integer.parseInt(a[i - 2]);
                        k = (int) Math.pow(m, n);
                        flag = true;
                        note = i;
                        break;
                    }
                }
                if (flag)
                    break;
            }
            boolean flag2 = false;
            for (int i = 0; i < a.length; i++)
            {
                if (i == note - 2)
                {
                    i += 2;
                    ans.append(k).append(" ");
                    flag2 = true;
                    continue;
                }
                ans.append(a[i]).append(" ");
            }
            if (!flag2)
                break;
            out.println(ans);

        }
        out.close();
    }
}