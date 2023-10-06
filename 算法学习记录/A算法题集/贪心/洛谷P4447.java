
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

import static java.lang.System.in;

/*
    本解法思路受洛谷第一条题解启发
 */
public class Main {
    static int n;
    static int ans = 0;
    static int min = (int) 1e9;
    //原始数据数组
    static int[] a;
    //数据频次记录映射
    static Map<Integer, Integer> time;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        n = (int) st.nval;
        a = new int[n];
        for (int i = 0; i < n; i++)
        {
            st.nextToken();
            a[i] = (int) st.nval;
        }

        Arrays.sort(a);
        //将排序后的数组a去重后放入数组b
        //同时记录每个数的出现次数
        int [] b = new int[n];
        int index=0;

        int node = a[0];
        int sum = 0;
        time = new HashMap<>();

        for (int now : a)
        {
            if (now == node)
                sum++;
            else
            {
                time.put(node, sum);
                b[index++]=node;
                sum = 1;
                node = now;
            }
        }
        time.put(node, sum);
        b[index]=node;

        //标记最左端的高度
        node=time.get(b[0]);

        for (int i = 0; i <=index; i++)
        {
            int now = b[i];
            int next = 0;
            int high2 = -1;
            int high1 = time.get(now);
            if (i < index)
            {
                next = b[i+1];
                high2 = time.get(next);
            }
            if (now + 1 != next || high2 < high1)
            {
                //比较最左端高度和当前高度差
                if(now + 1 == next&&high2<high1)
                    node=Math.min(node,high1-high2);
                //当遇到不连续时,往回倒带,记录连续的个数
                int j = i;
                for (; j >= 0; j--)
                {
                    int high = time.get(b[j]);
                    if (high == 0)
                        break;
                    else
                    {
                        ans++;
                        //直接减去最左端的高度
                        time.put(b[j], high - node);
                    }
                }
                //更新最左端的高度
                node=time.get(b[j+1]);

                min = Math.min(ans, min);
                ans = 0;
                //当前值高度>1时,回到该值继续
                if (time.get(now) >= 1)
                    i--;
            }
        }
        System.out.println(min);
    }
}

