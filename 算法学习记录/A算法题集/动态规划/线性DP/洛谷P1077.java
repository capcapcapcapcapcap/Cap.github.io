import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main{
    static int n;
    static int m;
    static int mod = (int) 1e6 + 7;
    static int[] flower;
    static int[] f;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        flower = new int[n + 1];
        f=new int[m+1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            flower[i] = (int) st.nval;
        }
        f[0] = 1;
        //若已摆放a盆花,现要移除k盆花,再加入某种花k盆
        //则更新的方案和等于原摆放a盆花的方案+原摆放a-k盆花的方案
        for (int i = 1; i <= n; i++)//需要用到第i种花
        {
            for (int j = m; j > 0; j--)//要摆放的总花数
                for (int k = 1; k <= Math.min(flower[i], j); k++)//第i种花只摆出k盆
                    f[j]=(f[j]+f[j-k])%mod;//未用到第i种花的情况加上用到了第i种花的情况
        }
        System.out.println(f[m]);
    }
}