

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main {
    static int n;
    static int[] a;
    static int x;
    static long ans=0;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        x = (int) st.nval;

        a = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            a[i] = (int) st.nval;
        }
        for (int i = 2; i <= n; i++)
        {
            int sum=a[i]+a[i-1];
            int diff=sum-x;
            if(diff>0) 
            {
                ans+=diff;
                if(a[i]>=diff)
                    a[i]-=diff;
                else{
                    a[i-1]-=(diff-a[i]);
                    a[i]=0;
                }
            }

        }
        System.out.println(ans);
    }

}