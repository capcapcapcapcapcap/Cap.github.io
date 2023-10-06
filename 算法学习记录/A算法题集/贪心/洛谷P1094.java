

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    static int w;
    static int n;
    static int[] p;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        w = (int) st.nval;
        st.nextToken();
        n = (int) st.nval;
        p=new int[n+1];

        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            p[i] = (int) st.nval;
        }
        Arrays.sort(p);

        int ans=0;
        int node=n;
        for (int i = 1; i <= n; i++)
        {
            int a=p[i];
            if(a==0)
                continue;
            for(int j=node;j>i;j--)
            {
                int b=p[j];
                if(a+b<=w)
                {
                    node=j-1;
                    p[i]=0;
                    p[j] = 0;
                    break;
                }
            }
            ans++;

        }
        System.out.println(ans);
    }
}