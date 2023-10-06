

import java.util.Scanner;
public class 洛谷P3802 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int[] a = new int[8];
        double ans=1;
        int sum=0;
        for (int i = 1; i <= 7; i++)
        {
            a[i] = in.nextInt();
            sum+=a[i];
        }
        for(int i=1;i<=6;i++)
            ans=ans*(double) a[i]/(sum+1-i)*i;
        ans=ans*a[7]*7.0;

        System.out.format("%.3f",ans);


    }
}
