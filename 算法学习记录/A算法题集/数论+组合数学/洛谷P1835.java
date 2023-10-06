
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MainF {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int min = in.nextInt();
        int max = in.nextInt();
        int count = 0;
        boolean[] notPrime =new boolean[max-min+1];
        for (int now : EratosthenesSieve(50000))
        {
            if(now>max)
                break;
            //找出区间内第一个now的倍数
            long k=Math.max(2L,((min-1)/now+1))*now;
            //将所有now的倍数标记
            for(;k<=max;k+=now)
                if(k-min>=0)
                    notPrime[(int)k-min] = true;
        }
        for (boolean now : notPrime)
            if(!now)
                count++;
        if(min==1)
            count--;
        System.out.println(count);
    }



    //埃氏筛法(筛选1-n)间的素数
    public static List<Integer> EratosthenesSieve(int n)
    {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        // 初始化数组，默认所有数都为素数
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++)
        {
            if (isPrime[i])
                // 将当前素数的倍数标记为合数
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        }

        // 将所有为素数的数添加到结果列表中
        for (int i = 2; i <= n; i++)
            if (isPrime[i])
                primes.add(i);

        return primes;
    }

    static boolean isPrime(int x)
    {
        if (x <= 1)
            return false;
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        return true;

    }
}


