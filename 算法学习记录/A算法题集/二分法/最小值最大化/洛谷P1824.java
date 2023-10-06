
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class Main{
    static int N;
    static int C;
    static int[] a;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        N=(int)st.nval;
        st.nextToken();
        C=(int)st.nval;
        a=new int[N+1];
        for(int i = 1; i <= N; i++)
        {
            st.nextToken();
            a[i]=(int)st.nval;

        }
        Arrays.sort(a);
        int l=0;
        int r=a[N]-a[1];
        int ans=0;
        while(l<r)
        {
            int mid=(l+r+1)/2;
            if(check(mid))
            {
                ans=mid;
                l=mid;
            }
            else r=mid-1;
        }
        System.out.println(ans);
    }
    static boolean check(int d)
    {
        int x=a[1];
        int sum=1;
        for(int i=2;i<=N;i++)
        {
            if(a[i]-x>=d)
            {
                sum++;
                x=a[i];
            }
            if(sum>=C)
                return true;
        }
        return false;
    }


}