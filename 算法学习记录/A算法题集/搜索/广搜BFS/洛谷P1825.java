
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point other)
        {
            return (x == other.x && y == other.y);
        }
    }

    static Point start;
    static Point end;

    static int n;
    static int m;
    static int ans = (int) 1e9;
    //迷宫
    static char[][] maze;
    //传送门位置
    static Map<Character, Point[]> turn;
    //传送门使用记录
    static boolean[][] use;
    //步数
    static int[][] step;

    static Queue<Point> que;
    //上下左右
    static int[][] walk = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        step = new int[n][m];
        use = new boolean[n][m];
        que = new LinkedList<>();
        turn = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (int j = 0; j < m; j++)
            {
                char ch = str.charAt(j);
                maze[i][j] = str.charAt(j);

                if (ch == '@')
                {
                    start = new Point(i, j);

                } 
                else if (ch == '=')
                {
                    end = new Point(i, j);
                    step[i][j] = 1;
                } 
                else if (ch >= 'A' && ch <= 'Z')
                {
                    if (!turn.containsKey(ch))
                    {
                        Point[] a = new Point[2];
                        a[0] = new Point(i, j);
                        turn.put(ch, a);
                    } 
                    else turn.get(ch)[1] = new Point(i, j);
                }
            }
        }

        que.offer(end);
        bfs();
        System.out.println(ans);

    }

    static void bfs()
    {
        while (!que.isEmpty())
        {
            Point now = que.poll();
            int x = now.x;
            int y = now.y;

            if (now.equals(start))
                ans = Math.min(ans, step[x][y] - 1);

            for (int i = 0; i < 4; i++)
            {
                int xx = x + walk[i][0];
                int yy = y + walk[i][1];

                if (xx < 0 || yy < 0 || xx >= n || yy >= m)
                    continue;

                Point next = new Point(xx, yy);
                //传送门特判
                if (maze[xx][yy] >= 'A' && maze[xx][yy] <= 'Z')
                {
                    //若该传送门已使用则跳过
                    if (!use[xx][yy])
                    {
                        use[xx][yy] = true;
                        //该传送门是否有对应门
                        Point next2 = turn.get(maze[xx][yy])[1];
                        if (next2 != null)
                        {
                            //确定对应门位置
                            if (next.equals(next2))
                                next2 = turn.get(maze[xx][yy])[0];

                            que.offer(next2);
                            step[next2.x][next2.y] = step[x][y] + 1;
                        }
                        else 
                        {
                            //原地传送
                            step[xx][yy] = step[x][y] + 1;
                            que.offer(next);
                        }

                    }
                } 
                else if (maze[xx][yy] != '#' && step[xx][yy] == 0)
                {
                    step[xx][yy] = step[x][y] + 1;
                    que.offer(next);
                }
            }
        }
    }
}