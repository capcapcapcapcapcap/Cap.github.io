

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] word;
    static int[] time;
    static StringBuffer ans=new StringBuffer();
    static int n;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        word = new String[n + 1];
        time = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            word[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        for (int i = 1; i <= n; i++)
        {
            if (word[i].startsWith(start))
            {
                StringBuffer tmp = new StringBuffer(word[i]);
                time[i]++;
                dfs(tmp);
                time[i]--;
            }
        }
        System.out.println(ans.length());
    }

    static void dfs(StringBuffer anss)
    {
        if(anss.length()>ans.length())
            ans=anss;
        for (int i = 1; i <= n; i++)
        {
            int len = anss.length();
            if(time[i]>1)
                continue;
            for (int j = len - 1; j > 0; j--)
            {
                String str = anss.substring(j);
                if (word[i].length()>str.length()&&word[i].startsWith(str))
                {
                    StringBuffer tmp=new StringBuffer(anss);
                    tmp.append(word[i].substring(len - j));
                    time[i]++;
                    dfs(tmp);
                    time[i]--;
                    break;
                }
            }
        }
    }

}
