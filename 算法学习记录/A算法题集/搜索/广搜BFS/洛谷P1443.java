

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 洛谷P1443{
    static int n;
    static int m;
    static int x;
    static int y;
    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] ans;
    static int[][] walk;
    static Queue<Point> queue;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        m=input.nextInt();
        x=input.nextInt();
        y=input.nextInt();
        walk=new int[][]{{2,1},{1,2},{-1,2},{-2,1},{1,-2},{2,-1},{-2,-1},{-1,-2}};
        ans=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                ans[i][j]=-1;
        ans[x][y]=0;
        queue=new LinkedList<>();
        queue.offer(new Point(x,y));
        bfs();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
                System.out.format("%-5d",ans[i][j]);
            System.out.println();
        }
    }
    static void bfs()
    {
        while(!queue.isEmpty())
        {
            Point p=queue.poll();
            int x=p.x;
            int y=p.y;
            int now=ans[x][y];
            for(int i=0;i<8;i++)
            {
                int xx=x+walk[i][0];
                int yy=y+walk[i][1];
                if(xx<1||xx>n||yy<1||yy>m||ans[xx][yy]!=-1)
                    continue;
                ans[xx][yy]=now+1;
                queue.offer(new Point(xx,yy));
            }
        }
    }

}