
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    static int mod = (int) 1e9 + 7;
    //阶乘
    static long[] fac;
    //3的幂次方
    static long[] pow;
    //逆元
    static long[] inv;

    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(System.out);
        FastReader in = new FastReader();

        int n = in.nextInt();
        int k = in.nextInt();

        fac = new long[n + 1];
        pow = new long[n + 1];
        inv = new long[n + 1];
        fac[0] = 1;
        pow[0] = 1;
        inv[0]=1;
        for (int i = 1; i <= n; i++)
        {
            fac[i] = fac[i - 1] * i % mod;
            pow[i] = pow[i - 1] * 3 % mod;
            inv[i]=inv[i-1]*qPow(i,mod-2)%mod;
        }



        long ans = 0;
        if (k == 0)
            ans = pow[n];

/*公式:ans=求和( pow(3,n+1-2p) * C(k-1,p-1) * C(n-k,p-1) +
 * pow(3,n-2p) * C(k-1,p-1) * C(n-k,p) )
 */                
        for (int p = 1; p <= k; p++)
        {
            long b = combination(k - 1, p - 1);
            long a = 0;
            long c = 0;
            if (n + 1 - k - p >= 0)
            {
                a = pow[n + 1 - 2 * p];
                c = combination(n - k, p - 1);
            }
            long d = 0;
            long e = 0;
            if (n - k - p >= 0)
            {
                d = pow[n - 2 * p];
                e = combination(n - k, p);
            }
            long f = b * (a * c % mod + d * e % mod) % mod;
            ans = (ans + f) % mod;
        }
        out.println(ans);
        out.close();
    }

    static long qPow(long a, long b)
    {
        long ans = 1;
        while (b != 0)
        {
            if (((b & 1) == 1))
            {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans % mod;
    }

    public static long combination(int n, int m)
    {
        long a = fac[n] * inv[m] % mod;
        long b = inv[n-m];
        return a * b % mod;
    }
}
