

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.sql.Array;
import java.util.ArrayList;

import static java.lang.System.in;

public class Main {
    static int n;
    static int[] d;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        n = (int) st.nval;
        d=new int[n+1];
        int ans=0;

        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            d[i] = (int) st.nval;
        }
        for (int i = 2; i <= n; i++)
        {
            if(d[i]>d[i-1])
                ans+=d[i]-d[i-1];
        }
        ans+=d[1];

        System.out.println(ans);
    }
}s