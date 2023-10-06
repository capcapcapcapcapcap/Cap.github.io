
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main{
    static int n;
    static int k;
    static int[] still;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n=(int)st.nval;
        st.nextToken();
        k=(int)st.nval;
        still=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            st.nextToken();
            still[i]=(int)st.nval;
        }
        Arrays.sort(still);
        int l=0;
        int r=still[n];
        long ans=0;
        while(l<r)
        {
            int mid=(l+r+1)>>1;
            if(check(mid))
            {
                ans=mid;
                l=mid;
            }
            else r=mid-1;
        }
        System.out.println(ans);

    }
    public static boolean check(int L)
    {
        int sum=0;
        for(int i=n;i>=1;i--)
        {
            int tmp=still[i];
            while(tmp>=L)
            {
                tmp-=L;
                sum++;
                if(sum>=k)
                    return true;
            }
        }
        return false;
    }
}
