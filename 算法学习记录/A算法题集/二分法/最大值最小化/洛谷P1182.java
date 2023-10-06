
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class Main{
    static int N;
    static int M;
    static int[] gp;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        st.nextToken();
        N = (int) st.nval;
        st.nextToken();
        M = (int) st.nval;
        gp = new int[N+1];

        
        for (int i = 1; i <= N; i++)
        {
            st.nextToken();
            gp[i] = (int) st.nval;
        }

        int l = 1;
        int r=(int)1e9;
        int ans = 0;
        while (l <r)
        {
            int mid = (l + r) >>1;
            if (check(mid))
            {
                ans = mid;
                r = mid ;
            } else l = mid + 1;
        }
        System.out.println(ans);

    }

    public static boolean check(int x)
    {
        int now=0;
        int sum=0;
        for (int i = 1; i <= N; i++)
        {
            sum=0;
            now++;
            if(now>M)
                return false;
            //不需要考虑段数<M的情况，
            //因为那说明当前x不是最优解
            for(int j=i;j<=N;j++)
            {
                sum+=gp[j];
                if(sum>x)
                {
                    sum-=gp[j];
                    i=j-1;
                    break;
                }
                i=j;
            }
        }
        return true;
    }
}