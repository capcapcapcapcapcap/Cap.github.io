package com.nowcoder8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.in;
import static java.lang.System.load;

/**
 * @author Cap-陈奥鹏
 * @version 1.0
 */
public class Main {
    static class Secretary {
        int left;
        int right;

        public Secretary(int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }

    static int n;
    static int a;
    static int b;
    static Secretary[] S;

    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        st.nextToken();
        n = (int) st.nval;
        st.nextToken();
        a = (int) st.nval;
        st.nextToken();
        b = (int) st.nval;

        S = new Secretary[n];

        for (int i = 0; i < n; i++)
        {
            st.nextToken();
            int l = (int) st.nval;
            st.nextToken();
            int r = (int) st.nval;
            S[i] = new Secretary(l, r);

        }

        /*
            根据题意我们可以知道，大臣1和大臣2位置能交换的必要条件是：大臣2放在大臣1的前面得到的最大值更加小。那么我们分别讨论两种情况下的最大值，假设只有两个大臣：
            如果大臣1放在前面，他俩获得的金币数分别为：
            a0/b1,a0*a1/b2
            如果大臣2放在前面，他俩获得的金币数分别为：
            a0/b2,a0*a2/b1
            首先，我们约去式子里面的a0，然后分别讨论两种情况的最大值，就变成了比较：
            max(1/b1,a1/b2)和max(1/b2,a2/b1)的大小
            根据0<a，a是整数的条件，我们可以得出:
            a1/b2 >= 1/b2、1/b1 <= a2/b1

            那么，如果1/b1是最大的，则有
            1/b1>=a2/b1，只可能左右两边相等，则有1/b2<=a2/b1，所以两种情况的最大值是一样的，则不用交换。
            同理可得1/b2是最大的情况也不用交换。
            那么我们就只要a1/b2和a2/b1的大小就可以了，也就是说如果a1/b2>a2/b1，那么就要交换，变形得：
            a1*b1 > a2*b2
            表示要交换，我们排序就只要按照a*b的从小到大排就可以了。
         */
        Arrays.sort(S, new Comparator<Secretary>() {
            @Override
            public int compare(Secretary o1, Secretary o2)
            {
                return Integer.compare(o1.right*o1.left, o2.right*o2.left);
            }
        });

        BigInteger s = BigInteger.valueOf(a);
        BigInteger max = null;
        for (int i = 0; i < n; i++)
        {
            BigInteger ans=s.divide(BigInteger.valueOf(S[i].right));
            if(i==0)
                max=ans;
            else max=max.compareTo(ans)>=0?max:ans;
            s = s.multiply(BigInteger.valueOf(S[i].left));
        }

        System.out.println(max);
    }
}
