import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 洛谷P2437{
    static int m;
    static int n;
  
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        m=(int)st.nval;
        st.nextToken();
        n=(int)st.nval;
         BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);
        for (int i = m + 1; i <= n; i++)
        {
            c =a.add(b);
            a = b;
            b = c;
        }
        System.out.println(c);

    }
}