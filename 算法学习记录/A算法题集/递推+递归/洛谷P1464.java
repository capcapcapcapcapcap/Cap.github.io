
import java.io.*;
import java.util.Scanner;

public class 洛谷P1464{
    public static long w(long a,long b,long c)
    {
        if(a<=0||b<=0||c<=0)
            return 1;
        else if(a>20||b>20||c>20)
            return w(20,20,20);
        else if(f[(int) a][(int) b][(int) c]!=0)
            return f[(int) a][(int) b][(int) c];
        else if(a<b&&b<c)
            f[(int) a][(int) b][(int) c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        else f[(int) a][(int) b][(int) c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        return f[(int) a][(int) b][(int) c];
    }
    static long[][][] f=new long[25][25][25];
    public static void main(String[] args) throws IOException
    {
        long a,b,c;
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            st.nextToken();
            a=(long)st.nval;
            st.nextToken();
            b=(long)st.nval;
            st.nextToken();
            c=(long)st.nval;
            if(a==-1&&b==-1&&c==-1)
                break;
            bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
            bw.flush();
            //System.out.printf("",a,b,c,w(a,b,c));
        }
        bw.close();

    }
}