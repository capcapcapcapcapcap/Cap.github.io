import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class Main {
    static int L;
    static int N;
    static int M;
    static int[] stone;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        L=(int)st.nval;
        st.nextToken();
        N=(int)st.nval;
        st.nextToken();
        M=(int)st.nval;
        stone=new int[N+2];
        for(int i=1;i<=N;i++)
        {
            st.nextToken();
            stone[i]=(int)st.nval;
        }
        stone[N+1]=L;
        int l=1;
        int r=L;
        int ans=0;
        while(l<r)
        {
            int mid=(r+l+1)/2;
            if(check(mid))
            {
                ans=mid;
                l=mid;
            }
            else r=mid-1;
        }
        System.out.println(ans);
    }
    public static boolean check(int x)
    {
        int sum=0;
        int now=stone[0];
        for(int i=1;i<=N+1;i++)
        {
            if(stone[i]-now<x)
                sum++;
            else now=stone[i];
        }
        if(sum<=M)
            return true;
        else return false;
    }

}
