

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 洛谷P1002{
    static long[][] chess;
    static int a;
    static int b;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        a=(int)st.nval;
        st.nextToken();
        b=(int)st.nval;
        chess=new long[a+1][b+1];
        st.nextToken();
        int c=(int)st.nval;
        st.nextToken();
        int d=(int)st.nval;
        chess[0][0]=1;
        horse(c,d);

        for(int i=0;i<=a;i++)
        {
            for(int j=0;j<=b;j++)
            {
                if(chess[i][j]==-1)
                    chess[i][j]=0;
                else
                {
                    if(i>=1)
                        chess[i][j]+=chess[i-1][j];
                    if(j>=1)
                        chess[i][j]+=chess[i][j-1];
                }
            }
        }
        System.out.print(chess[a][b]);
    }
    static void horse(int aa,int bb)
    {
        chess[aa][bb]=-1;
        if(aa>=1)
        {
            if(bb>=2)
                chess[aa-1][bb-2]=-1;
            if(bb+2<=b)
                chess[aa-1][bb+2]=-1;
        }
        if(aa>=2)
        {
            if(bb>=1)
                chess[aa-2][bb-1]=-1;
            if(bb+1<=b)
                chess[aa-2][bb+1]=-1;
        }
        if(aa+1<=a)
        {
            if(bb>=2)
                chess[aa+1][bb-2]=-1;
            if(bb+2<=b)
                chess[aa+1][bb+2]=-1;
        }
        if(aa+2<=a)
        {
            if(bb>=2)
                chess[aa+2][bb-1]=-1;
            if(bb+2<=b)
                chess[aa+2][bb+1]=-1;
        }
    }
}