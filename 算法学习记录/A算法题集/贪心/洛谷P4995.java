

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    static int n;
    static int[] h;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        n = (int) st.nval;
        h = new int[n + 1];

        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            h[i] = (int) st.nval;
        }
        Arrays.sort(h);
        long ans = h[n] * h[n];

        for (int i = 1; i <=n; i++)
        {
            int a=0;
            int b=0;
            if(i<n-i+1)
                b=h[i]-h[n-i+1];
            ans+=b*b;
            if(i<n-i)
                a=h[i]-h[n-i];
            else break;
            ans+=a*a;

        }
        System.out.println(ans);
    }
}