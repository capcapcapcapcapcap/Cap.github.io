import java.util.Scanner;


public class MainA {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int b=in.nextInt();
        int d=in.nextInt();
        int[] a=new int[n];
        a[0]=0;
        int index=0;

        for (int i = 1; i < Math.pow(2,b); i++)
        {
            if(index==n-1)
                break;

            boolean flag=true;

            for(int j=0;j<=index;j++)
                if(countDifferentBits(i,a[j])<d)
                    flag = false;

            if(flag)
                a[++index]=i;
        }
        int num=0;
        for(int now:a)
        {

            System.out.print(now+" ");
            num++;
            if(num%10==0)
                System.out.println();
        }

    }
    public static int countDifferentBits(int num1, int num2) {
        int count = 0;
        int xor = num1 ^ num2;  // 使用异或运算符获取两个数的不同位
        while (xor != 0) {
            if ((xor & 1) == 1) {  // 检查最低位是否为1
                count++;
            }
            xor = xor >> 1;  // 右移一位，继续检查下一位
        }
        return count;
    }
}
