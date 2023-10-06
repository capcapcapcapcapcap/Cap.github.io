import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static int[] width;
    static int[] height;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        N = (int) st.nval;
        st.nextToken();
        K = (int) st.nval;
        width = new int[N];
        height = new int[N];
        for (int i = 0; i < N; i++)
        {
            st.nextToken();
            width[i] = (int) st.nval;
            st.nextToken();
            height[i] = (int) st.nval;
        }
        int l = 1;
        int r = (int) 1e5;
        int ans = 0;
        while (l < r)
        {
            int mid = (l + r+1) >> 1;
            if (check(mid))
            {
                ans = mid;
                l = mid ;
            } else r = mid - 1;
        }
        System.out.println(ans);
    }

    public static boolean check(int n)
    {
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += width[i] / n * (height[i] / n);
        return sum >= K;
    }

}
