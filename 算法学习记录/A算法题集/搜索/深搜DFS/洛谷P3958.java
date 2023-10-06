

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P3958{
    static int n;
    static int h;
    static int r;
    static Point[] chess;
    static boolean ans;
    static boolean[] chess1;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int T=(int)st.nval;
        while(T-->0)
        {
            st.nextToken();
            n=(int)st.nval;
            st.nextToken();
            h=(int)st.nval;
            st.nextToken();
            r=(int)st.nval;
            chess=new Point[n+1];
            for(int i = 1; i <=n;i++)
            {
                st.nextToken();
                int x=(int)st.nval;
                st.nextToken();
                int y=(int)st.nval;
                st.nextToken();
                int z=(int)st.nval;
                chess[i]=new Point(x,y,z);
            }
            Arrays.sort(chess);
            ans=false;
            chess1=new boolean[n+1];
            for(int j=1;j<=n;j++)
                if(chess[j].z<=r)
                    dfs(j);
            if(ans)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
    static void dfs(int k)
    {
        if(ans)
            return;
        if(chess[k].z+r >= h)
        {
            ans=true;
            return;
        }
        if(chess[n].z+r<h||k==n)
            return;
        chess1[k]=true;
        for (int kk = 1; kk <= n;kk++) {
            if(ans)
                return;
            if(cal(k,kk)&&!chess1[kk])
                dfs(kk);
        }

    }
    static boolean cal(int k,int kk)
    {
        double a=Math.sqrt((Math.pow(chess[k].x-chess[kk].x,2))+(Math.pow(chess[k].y-chess[kk].y,2))+(Math.pow(chess[k].z-chess[kk].z,2)));
        return a <= 2 * r;
    }


}
class Point implements Comparable<Point>
{
    int x;
    int y;
    int z;

    public Point(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public int compareTo(Point other) {
        if (other == null) {
            return 0;
        }
        return Integer.compare(this.z, other.z);
    }
}
