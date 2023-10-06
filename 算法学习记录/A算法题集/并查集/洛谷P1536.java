

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.TreeSet;

import static java.lang.System.console;
import static java.lang.System.in;

public class Main {
    static int n;
    static int m;
    static int p;
    static int[] father;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));

        while(true)
        {
            st.nextToken();
            n = (int) st.nval;
            if(n==0)
                break;
            st.nextToken();
            m = (int) st.nval;

            father = new int[n + 1];
            for (int i = 1; i <= n; i++)
                father[i] = i;

            for (int i = 1; i <= m; i++)
            {
                st.nextToken();
                int a = (int) st.nval;
                st.nextToken();
                int b = (int) st.nval;
                merge(a, b);
            }

            int ans=0;
            for (int i = 1; i <= n; i++)
            {
                for(int j=i+1;j<=n;j++)
                {
                    if(find(i)!=find(j))
                    {
                        ans++;
                        merge(i,j);
                    }
                }
            }
            System.out.println(ans);
        }

    }
    //查找最高父类
    static int find(int x)
    {
        if(x==father[x])
            return x;
        //深入查找父类的父类
        else return father[x]=find(father[x]);
    }

    //合并统一二者父类
    static void merge(int a,int b)
    {
        int fa1=find(a);
        int fa2=find(b);
        if(fa1!=fa2)
            father[fa1]=fa2;
    }
}