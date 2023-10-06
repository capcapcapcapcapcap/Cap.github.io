

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main{
    static int n;
    static List<Integer> a;
    static Queue<Integer> b;
    static int[] f;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n=(int)st.nval;

        a=new LinkedList<>();
        b=new LinkedList<>();

        f=new int [n+1];
        for(int i=1;i<=n;i++)
        {
            st.nextToken();
            a.add((int) st.nval);
        }
        Collections.sort(a);

        int ans=0;
        for(int i=1;i<n;i++)
        {
            int m=0;
            int k=0;
            if(!a.isEmpty())
            {
                if (b.isEmpty())
                    m = a.remove(0);
                else m = a.get(0) < b.peek() ? a.remove(0) : b.poll();
            }
            else if(!b.isEmpty())
                m=b.poll();

            if(!a.isEmpty())
            {
                if (b.isEmpty())
                    k = a.remove(0);
                else k = a.get(0) < b.peek() ? a.remove(0) : b.poll();
            }
            else if(!b.isEmpty())
                k=b.poll();
            ans += m + k;

            b.offer(m+k);
        }
        System.out.println(ans);
    }
}