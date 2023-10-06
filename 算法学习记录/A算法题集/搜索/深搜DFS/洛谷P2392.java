import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class 洛谷P2392 {
    static int[] s=new int[4];
    static int[] h = new int[20];
    static int max = 0;
    static int now = 0;
    static int sum = 0;
    static int ans = 0;
    static int num = 0;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 0; i < 4; i++)
        {
            st.nextToken();
            s[i] = (int) st.nval;
        }
        for (int i = 0; i < 4; i++)
        {
            now = 0;
            num = s[i];
            sum = 0;
            for (int j = 0; j < num; j++)
            {
                st.nextToken();
                h[j] = (int) st.nval;
                sum += h[j];
            }
            max = 0;
            dfs(0);
            ans += (sum - max);
        }
        System.out.println(ans);

    }

    static void dfs(int x)
    {
        if (x + 1 > num)
        {
            max = Math.max(max, now);
            return;
        }
        if (now + h[x] <= sum / 2)
        {
            now += h[x];
            dfs(x + 1);
            now -= h[x];
        }
        dfs(x + 1);
    }
}