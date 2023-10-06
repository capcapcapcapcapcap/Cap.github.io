

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main {

    static class Point{
        int time;
        int id;

        public Point(int time, int id)
        {
            this.time = time;
            this.id = id;
        }
    }
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        List<Point> list =new LinkedList<>();
        int[] f=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            st.nextToken();
            int time=(int)st.nval;
            list.add(new Point(time,i));
        }
        Collections.sort(list, new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2)
            {
                return Integer.compare(o1.time,o2.time);
            }
        });
        long ans=0;

        for(int i = 0; i < n; i++)
        {
            Point a=list.get(i);
            int time=a.time;
            int id=a.id;
            f[i+1]=time+f[i];
            if(i<n-1)
                ans+=f[i+1];
            System.out.print(id+" ");
        }

        BigDecimal d= BigDecimal.valueOf(1.0*ans/n);
        System.out.format("\n%.2f",d);
    }
}