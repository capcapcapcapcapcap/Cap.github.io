

import java.math.BigInteger;
import java.util.Scanner;

public class MainC {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        a=a.mod(BigInteger.valueOf(19260817));
        b=b.mod(BigInteger.valueOf(19260817));
        System.out.println(inv2(a.intValue(), b.intValue(), 19260817));
    }

    //快速幂取模
    static long qPow(long a, long b, long mod)
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

    //逆元
    static long inv(long a, long mod)
    {
        return qPow(a, mod - 2, mod);
    }

    //分数逆元
    static long inv2(long a, long b, long mod)
    {
        return inv(b, mod) * a % mod;
    }
}

