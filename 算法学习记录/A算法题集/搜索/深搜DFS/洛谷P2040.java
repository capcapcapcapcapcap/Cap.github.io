

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class 洛谷P2040{
    static int[][] light = new int[5][5];
    static int ans =  9;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i < 4; i++)
        {
            for (int j = 1; j < 4; j++)
            {
                st.nextToken();
                light[i][j] = (int) st.nval;
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    static void dfs( int sum)
    {
        if(sum>ans)
            return;
        boolean flag = true;
        for (int i = 1; i < 4; i++)
            for (int j = 1; j < 4; j++)
                if (light[i][j] == 0)
                    flag = false;
        if (flag)
        {
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = 1; i < 4; i++)
            for (int j = 1; j < 4; j++)
            {
                light[i][j] ^= 1;
                light[i - 1][j] ^= 1;
                light[i + 1][j] ^= 1;
                light[i][j - 1] ^= 1;
                light[i][j + 1] ^= 1;
                dfs(sum+1);
                light[i][j] ^= 1;
                light[i - 1][j] ^= 1;
                light[i + 1][j] ^= 1;
                light[i][j - 1] ^= 1;
                light[i][j + 1] ^= 1;
            }

    }

}