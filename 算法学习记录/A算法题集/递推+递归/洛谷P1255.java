import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P1255
{
    static int N;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        N=(int)st.nval;
        BigInteger a= BigInteger.valueOf(0);
        BigInteger b= BigInteger.valueOf(1);
        BigInteger sum= BigInteger.valueOf(0);
        for(int i=1;i<=N;i++)
        {
            sum=a.add(b);
            a=b;
            b=sum;
        }
        System.out.print(sum);
    }
}