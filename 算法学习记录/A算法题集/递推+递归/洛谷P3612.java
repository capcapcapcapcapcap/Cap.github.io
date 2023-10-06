import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class 洛谷P3612
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str=st.nextToken();
        int l=str.length();
        long n=Long.parseLong(st.nextToken());
        while(l<n)
        {
            long i=l;
            while(i*2<n)
                i*=2;
            n-=(i+1);
            if(n==0)
                n=i;
        }
        System.out.println(str.charAt((int)n-1));

    }
}