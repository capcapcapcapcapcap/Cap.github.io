import java.util.Scanner;

public class 洛谷P1044
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] h=new int[n+1];
        h[0]=1;
        h[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                h[i]+=h[j]*h[i-1-j];
            }
        }
        System.out.print(h[n]);

    }
}