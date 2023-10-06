import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import static java.lang.System.in;

/**
 * 双端单调队列
 * 后端用于比较和入列，保持队列单增/单减
 * 前端用于弹出队首，得到 min/max。
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        PrintWriter out = new PrintWriter(System.out);
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;

        int[] a=new int[n+1];
        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            a[i] = (int) st.nval;
        }

        Deque<Integer> queue=new ArrayDeque<>();

        //输出最小值
        for (int i = 1; i <= n; i++)
        {
            while(!queue.isEmpty()&&a[queue.peekLast()]>a[i])
                queue.pollLast();
            queue.offer(i);
            if(i>=k)
            {
                while(!queue.isEmpty()&&queue.peek()<=i-k)
                    queue.poll();
                out.print(a[queue.peek()]+" ");
            }
        }
        out.println();
        out.flush();
        queue.clear();
        //输出最大值
        for (int i = 1; i <= n; i++)
        {
            while(!queue.isEmpty()&&a[queue.peekLast()]<a[i])
                queue.pollLast();
            queue.offer(i);
            if(i>=k)
            {
                while(!queue.isEmpty()&&queue.peek()<=i-k)
                    queue.poll();
                out.print(a[queue.peek()]+" ");
            }
        }
        out.flush();
        out.close();
    }
}
