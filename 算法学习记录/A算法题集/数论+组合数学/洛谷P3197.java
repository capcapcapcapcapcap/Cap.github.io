
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
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

    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(System.out);
        FastReader in=new FastReader();
         long m=in.nextLong();
        long n=in.nextLong();
        BigInteger mod= BigInteger.valueOf(100003);
        BigInteger a= BigInteger.valueOf(n);
        BigInteger b=BigInteger.valueOf(m);
        BigInteger ans=b.modPow(a,mod);
        a=BigInteger.valueOf(n-1);
        BigInteger bb=BigInteger.valueOf(m-1);
        BigInteger ans2=bb.modPow(a,mod).multiply(b).mod(mod);
        a=ans.subtract(ans2).add(mod).mod(mod);
        out.println(a);
        out.close();
    }


}
