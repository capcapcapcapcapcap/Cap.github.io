



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


public class Main {
    static int n;
    static int ans = 0;

    static class Match {
        int start;
        int end;

        public Match(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException
    {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n=(int)st.nval;


        Match[] list=new Match[n];

        for (int i = 0; i < n; i++)
        {

            st.nextToken();
            int s=(int)st.nval;
            st.nextToken();
            int e=(int)st.nval;
            list[i]=new Match(s,e);
        }
//        Arrays.parallelSort(list,1, n+1, new Comparator<Match>() {
//
//            @Override
//            public int compare(Match n1, Match n2) {
//                return n1.end - n2.end;
//            }
//        });

        countingSort(list);
        int finish = 0;
        for (int i = 0; i < n; i++)
        {
            if (finish <= list[i].start)
            {
                ans++;
                finish = list[i].end;
            }
        }
        System.out.println(ans);

    }
    public static void countingSort(Match[] arr) {
        int max = 1000000; // 范围上限
        int[] count = new int[max + 1];

        // 统计每个end出现的次数
        for (Match a : arr) {
            count[a.end]++;
        }

        // 计算每个end的累计次数
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 根据计数数组构建排序后的数组
        Match[] sortedArray = new Match[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[count[arr[i].end] - 1] = arr[i];
            count[arr[i].end]--;
        }

        // 将排序后的数组复制回原数组
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }




}
