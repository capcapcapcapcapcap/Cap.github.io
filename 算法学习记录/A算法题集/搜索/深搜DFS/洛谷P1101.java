
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 洛谷P1101 {
    static String[] ch;
    static boolean[][] get;
    static ArrayList<Character> yz;
    static int n;
    static int step;
    static ArrayList<Integer> direct;
    //上,右,左下，右下,左,下，左上，右上，
    static int[][] walk = new int[][]{{-1, 0},{0, 1},{1,-1},{1,1}, {1, 0}, {0, -1}, {-1,-1},{-1,1}};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ch = new String[n + 1];
        get=new boolean[n+1][n];
        yz = new ArrayList<>();
        yz.add('0');

        for (int i = 0; i < 7; i++)
            yz.add("yizhong".charAt(i));

        for (int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            ch[i] = st.nextToken();
        }

        for(int i=1;i<=n;i++)
        {
            for(int j = 0; j < n; j++)
            {
                step=0;
                direct=new ArrayList();
                dfs(i,j,-1,0);
                if(step==7)
                {
                    for(int dir:direct)
                    {
                        int x=i;
                        int y=j;
                        for (int k = 0; k < 7; k++)
                        {
                            get[x][y] = true;
                            x += walk[dir][0];
                            y += walk[dir][1];

                        }
                    }
                }
            }
        }

        for(int i=1;i<=n;i++)
        {
            for(int j = 0; j < n; j++)
            {
               if(get[i][j])
                   System.out.print(ch[i].charAt(j));
               else System.out.print("*");
            }
            System.out.println();
        }
    }

    static void dfs(int x,int y,int dir,int step1)
    {
        step1++;
        if(step1==7)
        {
            direct.add(dir);
            step = step1;
            return;
        }
        char now=ch[x].charAt(y);
        if (!yz.contains(now))
            return;
        int index=yz.indexOf(now);//当前字母在单词中的位置
        if(dir==-1)
        {
            if(now=='y')//进入正序搜索
                for(int i=0;i<8;i++)
                {
                    int xx=x+walk[i][0];
                    int yy=y+walk[i][1];
                    if(xx<1||yy<0||xx>n||yy>=n)
                        continue;
                    char next=ch[xx].charAt(yy);
                    if(next=='i')
                        dfs(xx,yy,i,step1);
                }

            else return;//不为首字母，退出搜索
        }
        else
        {
            int xx=x+walk[dir][0];
            int yy=y+walk[dir][1];
            if(xx<1||yy<0||xx>n||yy>=n)
                return;
            char next=ch[xx].charAt(yy);
            if(next==yz.get(index+1))
                dfs(xx,yy,dir,step1);

        }
    }

}
