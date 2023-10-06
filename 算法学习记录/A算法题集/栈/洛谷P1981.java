

import java.io.*;
import java.math.BigInteger;
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
        String str=in.nextLine();
        char[] a=str.toCharArray();
        Stack<BigInteger> ans=new Stack();
        int sum=0;
        StringBuilder sb=new StringBuilder();

        boolean flag=false;
        for (char now : a)
        {

            if(now=='+'||now=='*')
            {
                ans.push(BigInteger.valueOf(Long.parseLong(sb.toString())));
                sb=new StringBuilder();
                if(flag)
                {
                    ans.push(ans.pop().multiply(ans.pop()));
                    flag=false;
                }
            }
            else sb.append(now);

            if(now=='*')
                flag=true;
            else if(now=='+')
                sum++;

        }
        ans.push(BigInteger.valueOf(Long.parseLong(sb.toString())));
        if(flag)
            ans.push(ans.pop().multiply(ans.pop()));
        while(sum-->0)
        {
            ans.push(ans.pop().add(ans.pop()));
        }
        String k=ans.pop().toString();
        if(k.length()>4)
        {
            boolean ll=true;
            for(int i=k.length()-4;i<k.length();i++)
            {
                if(ll&&k.charAt(i)!='0')
                {
                    out.print(k.charAt(i));
                    ll=false;
                }
                else if(!ll)
                    out.print(k.charAt(i));
            }
        }
        else out.println(k);
        out.close();
    }
}