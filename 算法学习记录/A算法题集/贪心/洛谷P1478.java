

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    static int n;
    static int s;
    static int a;
    static int b;
    static class Apple
    {
        int x;
        int y;

        public Apple(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static Apple[] ap;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        s = (int) st.nval;
        st.nextToken();
        a = (int) st.nval;
        st.nextToken();
        b = (int) st.nval;
        ap=new Apple[n+1];

        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            ap[i]=new Apple(x,y);
        }

        Arrays.sort(ap,1,n+1, new Comparator<Apple>(){
            @Override
            public int compare(Apple o1, Apple o2)
            {
                return Integer.compare(o1.y,o2.y);
            }
        });

        int high=a+b;
        int ans=0;

        for (int i = 1; i <= n; i++)
        {
            if(s<ap[i].y)
                break;
            if(high>=ap[i].x)
            {
                ans++;
                s-=ap[i].y;
            }
        }
        System.out.println(ans);
    }
}
