

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
    static int[] high;
    static int[] g;
    static int[] d;
    static int ans = 0;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        high = new int[n + 2];
        g = new int[n + 1];
        d = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            high[i] = (int) st.nval;
            g[i]=1;
            d[i]=1;
        }
        //向左找出b<a,且比b低的人>比a低的人数
        //则将a-b间的人出列(因为b的右边一定<b,不满足条件)
        for (int i = 2; i <= n; i++)
        {
            for (int j = i - 1; j >= 1; j--)
            {
                if (high[i] > high[j] && g[i] <= g[j] + 1)
                    g[i] = g[j] + 1;
            }

        }
        //向右重复之前步骤
        for(int i=n-1;i>0;i--)
        {
            for (int j = i + 1; j <= n; j++)
            {
                if (high[i] > high[j] && d[i] <= d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }
        for(int i=1;i<=n;i++)
            ans=Math.max(g[i]+d[i]-1,ans);

        System.out.println(n-ans);
    }


}
