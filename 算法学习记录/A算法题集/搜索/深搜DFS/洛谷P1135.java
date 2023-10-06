

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P1135{
    static int N;
    static int A;
    static int B;
    static int[] K;
    static long[] node;
    static long ans = (long)1e17;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        N = (int) st.nval;
        st.nextToken();
        A = (int) st.nval;
        st.nextToken();
        B = (int) st.nval;
        K = new int[N + 1];
        node = new long[N + 1];
        for (int i = 1; i <= N; i++)
        {
            st.nextToken();
            K[i] = (int) st.nval;
        }
        dfs(A, 0);
        if(ans!=(long) 1e17)
            System.out.println(ans);
        else System.out.println(-1);
    }

    static void dfs(int now, long sum)
    {
        if (now == B)
        {
            ans = Math.min(ans, sum);
            return;

        }
        if(sum>=ans)
            return;
        if(node[now]!=0&&node[now]<=sum)
            return;
        node[now] = sum;

        if (now + K[now] <= N)
            dfs(now + K[now], sum + 1);
        if (now - K[now] >= 1)
            dfs(now - K[now], sum + 1);


    }
}
