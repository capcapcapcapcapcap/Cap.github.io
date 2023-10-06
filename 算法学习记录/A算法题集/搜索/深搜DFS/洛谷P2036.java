
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P2036{
    static int n;
    static int[] s;
    static int[] b;
    static int ss = 1;
    static int bb = 0;
    static int diff = (int) 1e9;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        s = new int[n + 1];
        b = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            s[i] = (int) st.nval;
            st.nextToken();
            b[i] = (int) st.nval;
        }
        dfs(1);
        System.out.println(diff);
    }

    static void dfs(int start)
    {
        if (diff == n)
            return;
        for (int i = start ; i <= n; i++)
        {
            ss *= s[i];
            bb += b[i];
            dfs(i + 1);
            diff = Math.min(diff, Math.abs(ss - bb));
            ss /= s[i];
            bb -= b[i];
        }
    }
}