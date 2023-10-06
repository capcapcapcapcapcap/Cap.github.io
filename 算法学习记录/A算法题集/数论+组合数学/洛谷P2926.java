

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        int n = (int) st.nval;

        //数字出现次数
        int[] time = new int[(int) 1e6 + 1];
        //每头牛的数字
        int[] cow = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            cow[i] = (int) st.nval;
            time[cow[i]]++;
        }

        
/*
        //倘若枚举每头牛数字的约数,时间复杂度将为O(n*根号n)
        for (int i = 1; i <= n; i++)
        {
            int ans = 0;
            for (int j = 1; j * j <= cow[i]; j++)
                if (cow[i] % j == 0)
                {
                    if (j * j == cow[i])
                        ans += time[j];
                    else ans += time[j] + time[cow[i] / j];
                }
            ans--;
            System.out.println(ans);
        }
*/
        
        //每个数字对应的拍打次数
        int[] pat = new int[(int) 1e6 + 1];

        //枚举1~1e6的所有倍数都可拍打该数字
        //该算法时间复杂度为O(n*logn)
        for (int i = 1; i <= (int)1e6; i++)
            for(int j=i;j<=(int)1e6;j+=i)
                pat[j]+=time[i];
        
        for (int i = 1; i <= n; i++)
            System.out.println(pat[cow[i]]-1);//不可拍打自己
    }
}