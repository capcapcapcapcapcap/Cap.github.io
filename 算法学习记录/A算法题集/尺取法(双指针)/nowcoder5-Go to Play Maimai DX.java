

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class nowcoder5-G{

    static int[] flag=new int[6];
    static int k;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int )st.nval;
        st.nextToken();
        k=(int)st.nval;
        int [] a=new int[n];
        int ans=n+1;
        for(int i = 0; i < n; i++)
        {
            st.nextToken();
            a[i]=(int)st.nval;
        }
        int l=0;
        int r=0;
        while(l<n)
        {
            while(r<n&&!judge())
            {
                flag[a[r]]++;
                r++;
            }
            if(judge())
                ans=Math.min(ans,r-l);
            flag[a[l]]--;
            l++;

        }
        System.out.println(ans);
    }
    static boolean judge()
    {
        return flag[1]>=1&&flag[2]>=1&&flag[3]>=1&&flag[4]>=k;
    }

}
