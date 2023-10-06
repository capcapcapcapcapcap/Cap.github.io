import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//bfs版
public class 洛谷P1596{
    static class Point
    {
        int x;int y;
        public Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static int n;
    static int m;
    static int ans = 0;
    static boolean[][] grass;
    static char[][] ch;
    static Queue<Point> queue;
    static int[][] walk = new int[][]{{-1, 0}, {0, 1}, {1, -1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch=new char[n][m];
        grass = new boolean[n][m];
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++)
                ch[i][j]=str.charAt(j);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!grass[i][j]&&ch[i][j]=='W')
                {
                    ans++;
                    grass[i][j]=true;
                    queue=new LinkedList();
                    queue.offer(new Point(i,j));
                    bfs();
                }
            }
        }

    }
    static void bfs()
    {
        while(!queue.isEmpty())
        {
            Point now=queue.poll();
            int x=now.x;
            int y=now.y;
            
            for (int i = 0; i < 8; i++)
            {
                int xx=x+walk[i][0];
                int yy=y+walk[i][1];
                if(xx<0||yy<0||xx>=n||yy>=m||grass[xx][yy])
                    continue;
                grass[xx][yy] = true;
                if(ch[xx][yy]=='W')
                    queue.offer(new Point(xx,yy));
            }
        }
    }
}