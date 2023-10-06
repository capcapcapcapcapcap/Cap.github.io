
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class Main{
    static int L;
    static int N;
    static int K;
    static int[] gp;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        L = (int) st.nval;
        st.nextToken();
        N = (int) st.nval;
        st.nextToken();
        K = (int) st.nval;
        gp = new int[N];
        for (int i = 0; i < N; i++)
        {
            st.nextToken();
            gp[i] = (int) st.nval;
        }
        int l = 1;
        int r = L;
        long ans = 0;
        while (l < r)
        {
            int mid = (l + r) / 2;
            if (check(mid))
            {
                ans = mid;
                r = mid;
            } else l = mid + 1;
        }
        System.out.println(ans);

    }

    public static boolean check(int x)
    {
        int sum = 0;
        int now=gp[0];
        for (int i = 1; i < N; i++)
        {
            while (gp[i] -now>x)
            {
                sum++;
                now+=x;
            }
            now=gp[i];
            if(sum>K)
                return false;
        }
        return true;
    }
}