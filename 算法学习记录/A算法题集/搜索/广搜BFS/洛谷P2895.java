import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 洛谷P2895 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] stars;
    static int[][] ans;
    static int[][] time;
    static Queue<Point> queue = new LinkedList<>();
    static int[][] walk = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int m = (int) st.nval;
        //注意可以走出牧场
        ans = new int[302][302];
        time = new int[302][302];
        for (int i = 0; i <= 301; i++)
        {
            Arrays.fill(time[i], 1001);
            Arrays.fill(ans[i],-1);
        }
        while (m-- > 0)
        {
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            st.nextToken();
            int t = (int) st.nval;
            time[x][y] = Math.min(time[x][y], t);
            for (int i = 0; i < 4; i++)
            {
                int xx = x + walk[i][0];
                int yy = y + walk[i][1];
                if(xx>=0&&yy>=0&&xx<=300&&yy<=300)
                    time[xx][yy] = Math.min(time[xx][yy], t);
            }
        }
        ans[0][0]=0;
        queue.offer(new Point(0,0));
        System.out.println(bfs());

    }
    static int bfs()
    {
        while(!queue.isEmpty())
        {
            Point p=queue.poll();
            int x=p.x;
            int y=p.y;
            int now=ans[x][y];
            if(time[x][y]>1000)
                return now;
            for(int i=0;i<4;i++)
            {
                int xx=x+walk[i][0];
                int yy=y+walk[i][1];
                if(xx<0||yy<0||xx>301||yy>301||ans[xx][yy]!=-1||ans[x][y]+1>=time[xx][yy])
                    continue;
                ans[xx][yy]=now+1;
                queue.offer(new Point(xx,yy));
            }
        }
        return -1;
    }


}