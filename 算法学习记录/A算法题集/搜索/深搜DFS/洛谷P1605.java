import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class 洛谷P1605 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static Point end;
    static int[][] ans;
    static int sum = 0;
    //static Queue<Point> queue = new LinkedList<>();
    static int[][] walk = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        ans = new int[n + 1][m + 1];
        st.nextToken();
        int t = (int) st.nval;
        st.nextToken();
        int sx = (int) st.nval;
        st.nextToken();
        int sy = (int) st.nval;
        st.nextToken();
        int fx = (int) st.nval;
        st.nextToken();
        int fy = (int) st.nval;
        ans[sx][sy] = 1;
        end = new Point(fx, fy);
        while (t-- > 0)
        {
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            ans[x][y] = -1;
        }
        dfs(sx,sy);
        System.out.println(sum);

    }

    static void dfs(int x, int y)
    {
        if (x == end.x && y == end.y)
        {
            sum++;
            return;
        }
        for(int i=0;i<4;i++)
        {
            int xx=x+walk[i][0];
            int yy=y+walk[i][1];
            if(xx<1||yy<1||xx>n||yy>m||ans[xx][yy]!=0)
                continue;
            ans[xx][yy]=1;
            dfs(xx,yy);
            ans[xx][yy]=0;
        }
    }
}