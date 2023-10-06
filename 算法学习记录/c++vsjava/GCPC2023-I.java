

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        int n = (int) st.nval;

        int[] flogs = new int[n + 1];

        for (int i = 1; i <= n; i++)
        {
            st.nextToken();
            int k = (int) st.nval;
            //记录每个青蛙的位置
            flogs[i] = k;
        }

        //记录睡莲的状态
        boolean[] jump = new boolean[flogs[n] + 1];
        for (int i = 1; i <= n; i++)
            jump[flogs[i]] = true;


        //记录空白睡莲
        LinkedList<Integer> blank = new LinkedList<>();
        for (int i = 1; i < jump.length; i++)
            if (!jump[i])
                blank.add(i);

        //最远的青蛙位置
        int max = flogs[n] + 1;
        blank.add(max);

        st.nextToken();
        int q = (int) st.nval;
        while (q-- > 0)
        {
            st.nextToken();
            int flog = (int) st.nval;

            //当前青蛙位置
            int loc = flogs[flog];

            int l = 0;
            int r = blank.size();
            int ans = 0;
            while (l <= r)
            {
                int mid = (r+l)/2;
                if (loc < blank.get(mid))
                {
                    ans = mid;
                    r = mid - 1;
                } else
                    l = mid + 1;
            }

            flogs[flog] = blank.get(ans);
            blank.set(ans, loc);

            if (flogs[flog] == max)
                blank.add(++max);

            System.out.println(flogs[flog]);
        }
    }
}
