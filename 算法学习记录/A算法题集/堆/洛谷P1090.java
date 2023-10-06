

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main{
    static int n;
    static List<Integer> a;
    static Queue<Integer> b;
    static int[] f;
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n=(int)st.nval;

        a=new LinkedList<>();
        b=new LinkedList<>();

        f=new int [n+1];
        for(int i=1;i<=n;i++)
        {
            st.nextToken();
            a.add((int) st.nval);
        }
        Collections.sort(a);

        int ans=0;
        for(int i=1;i<n;i++)
        {
            int m=0;
            int k=0;
//  两种方法,一为堆排序,可利用优先队列快捷实现;
/*
 *  二、如下
 *  倘若每次合并完果子都重新排序,必然超时,
 *  因此考虑将合并的果子先暂存在另一堆中,
 *  每次从两堆中取出最小值,再比较得更小者
 */

            if(!a.isEmpty())
            {
                if (b.isEmpty())
                    m = a.remove(0);
                else m = a.get(0) < b.peek() ? a.remove(0) : b.poll();
            }
            else if(!b.isEmpty())
                m=b.poll();

//  重复,取第二个果子
            if(!a.isEmpty())
            {
                if (b.isEmpty())
                    k = a.remove(0);
                else k = a.get(0) < b.peek() ? a.remove(0) : b.poll();
            }
            else if(!b.isEmpty())
                k=b.poll();
            ans += m + k;

            b.offer(m+k);
        }
        System.out.println(ans);
    }
}