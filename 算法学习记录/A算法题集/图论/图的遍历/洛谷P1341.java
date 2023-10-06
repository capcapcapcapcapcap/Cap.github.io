

import java.io.*;
import java.util.StringTokenizer;

/**
 * 欧拉路径：在一个图中，由i点出发，将每个边遍历一次最终到达j点的一条路径。
 * 欧拉回路：i=j时的欧拉路径。
 * 在无向图中
 * 判断欧拉回路，只要每个点的度数均为偶数即可。
 * 判断欧拉路径，如果有且仅有两个点的度数为奇数，就会存在一条从这两个中的一个到达另一个的欧拉路径。
 */
public class Main {
    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }


    static int[][] graph=new int[126][126];
    static int[] deg=new int[126];
    static StringBuilder ans=new StringBuilder();
    public static void main(String[] args) throws  Exception
    {
        FastReader in=new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n=in.nextInt();
        for (int i = 1; i <=n ; i++)
        {
            String a=in.nextLine();
            graph[a.charAt(0)][a.charAt(1)]=1;
            graph[a.charAt(1)][a.charAt(0)]=1;
            deg[a.charAt(1)]++;
            deg[a.charAt(0)]++;
        }

        int first=0;
        int sum=0;
        //判断 普通欧拉路径还是欧拉回路
        for(int i=0;i<126;i++)
        {
            if((deg[i]&1)!=0)
            {
                sum++;
                if(first==0)
                    first=i;
            }
        }

        //欧拉回路
        if(first==0)
            for(int i=0;i<126;i++)
            {
                if(deg[i]!=0)
                {
                    first =i;
                    break;
                }
            }
        //既不是普通欧拉路径也非欧拉回路
        if(sum!=0&&sum!=2)
            out.println("No Solution");
        else
        {
            dfs(first);
            out.println(ans);
        }
        out.close();
    }

    static void dfs(int i)
    {
        //遍历所有与该点相连的边
        for(int j=0;j<126;j++)
        {
            if(graph[i][j]!=0)
            {
                //删边
                graph[i][j]=graph[j][i]=0;
                dfs(j);
            }
        }
        //倒序计入答案
        ans.insert(0,(char)i);
    }
}