

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.in;

public class Main
{
    static int n;
    static int m;

    static class Milk{
        int price;
        int num;

        public Milk(int price, int num)
        {
            this.price = price;
            this.num = num;
        }
    }
    static Milk[] a;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        a=new Milk[m];

        for (int i = 0; i < m; i++)
        {
            st.nextToken();
            int x=(int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            a[i]=new Milk(x,y);

        }

        Arrays.sort(a, new Comparator<Milk>() {
            @Override
            public int compare(Milk o1, Milk o2)
            {
                return Integer.compare(o1.price, o2.price);
            }
        });

        int ans=0;
        for (Milk now : a)
        {
            if(n==0)
                break;
            int k=Math.min(n,now.num);
            ans+=now.price*k;
            n-=k;
        }
        System.out.println(ans);
    }
}