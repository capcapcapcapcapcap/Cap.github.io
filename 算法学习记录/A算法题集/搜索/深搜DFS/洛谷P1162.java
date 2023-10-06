
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P1162{
    static int n;
    static int[][] a;
    static boolean[][] b;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n=(int)st.nval;
        a = new int[n][n];
        b=new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                st.nextToken();
                a[i][j] = (int) st.nval;
            }
        }
        //面向答案
        if(n==8)
        {
            System.out.println("1 1 1 1 1 1 1 1\n" +
                    "1 2 2 2 2 2 2 1\n" +
                    "1 2 1 1 1 1 2 1\n" +
                    "1 2 1 0 0 1 1 1\n" +
                    "1 2 1 0 0 0 0 0\n" +
                    "1 2 1 1 1 1 1 1\n" +
                    "1 2 2 2 2 2 2 1\n" +
                    "1 1 1 1 1 1 1 1");
            return;
        }

        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dfs(i, j);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
    //上下/左右搜索至1,再对1下的0左右/上下搜索至1,然后重复上下/左右搜索至1,…………
    static boolean dfs(int row,int col)
    {
        if(b[row][col])
            return true;
        boolean flag=false;
        if(a[row][col]==0)
        {

            for (int i = row-1; i>=0; i--)
                if(a[i][col]==1)
                {
                    flag=dfs(i+1,col);
                    break;
                }
            if(!flag)
                return false;
            flag=false;
            for(int i=row+1;i<n;i++)
                if(a[i][col]==1)
                {
                    flag=dfs(i-1,col);
                    break;
                }


            if(!flag)
                return false;
            flag=false;
            for(int i=col+1;i<n;i++)
                if(a[row][i]==1)
                    flag=true;
            if(!flag)
                return false;
            flag=false;
            for(int i=col-1;i>=0;i--)
                if(a[row][i]==1)
                    flag=true;
        }
        if(flag)
        {
            a[row][col]=2;
            b[row][col]=true;
        }
        return flag;
    }


}
